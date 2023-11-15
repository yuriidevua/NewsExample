package com.arch.domain.news_group

import com.arch.comm.ErrorType
import com.arch.domain.BaseInteractor

import com.arch.portdata.IRepositoryApi
import com.arch.portdomain.news_group.IGroupsUseCase
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

class GroupUseCase @Inject constructor(private val repositoryApi: IRepositoryApi) :
    BaseInteractor(),
    IGroupsUseCase.UseCaseGroup {
    private lateinit var listenerPresenter: IGroupsUseCase.PresenterListener
    private val disposable = CompositeDisposable()
    override fun initListenerPresenter(listener: IGroupsUseCase.PresenterListener) {
        listenerPresenter = listener
    }

    override fun loadCategory() {
        disposable.add(Single.defer { repositoryApi.loadCategory() }
            .subscribeOn(Schedulers.io())
            .flatMap { mapperGroup(it) }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
               if (::listenerPresenter.isInitialized)listenerPresenter.listenerGroupInteractor(it)
            }, {
                Timber.tag(GroupUseCase::class.simpleName)
                    .e(it)
                if (::listenerPresenter.isInitialized) listenerPresenter.onMessage(
                    ErrorType.ERROR.type
                        .plus(it.message)
                )
            }))
    }

    override fun selectLanguage(language: String) {
        disposable.add(Single.defer { repositoryApi.newsLanguage(language) }
            .subscribeOn(Schedulers.io())
            .flatMap { mapperGroup(it) }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                if (::listenerPresenter.isInitialized) listenerPresenter.listenerGroupInteractor(it)
            }, {
                Timber.tag(GroupUseCase::class.simpleName)
                    .e(it)
                if (::listenerPresenter.isInitialized) listenerPresenter.onMessage(
                    ErrorType.ERROR.type
                        .plus(it.message)
                )
            }))
    }

    override fun startCase() {

    }

    override fun stopCase() {
        if (!disposable.isDisposed) disposable.clear()
    }
}