package com.arch.domain.web

import com.arch.comm.ErrorType
import com.arch.domain.BaseInteractor
import com.arch.domain.news.NewsUseCase
import com.arch.portdata.IRepositoryDAO
import com.arch.portdomain.model.NewsModel
import com.arch.portdomain.web.IWebUseCase
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

class WebUseCase @Inject constructor(private val repositoryDao : IRepositoryDAO)
    : BaseInteractor(), IWebUseCase.UseCaseWeb {
    private lateinit var presenterListener : IWebUseCase.PresenterListener
    private val disposable = CompositeDisposable()
    override fun initListener(listener: IWebUseCase.PresenterListener) {
        presenterListener = listener
    }

    override fun saveNews(news: NewsModel) {
        disposable.add(Single.defer{mapperDataNews(news)}
            .subscribeOn(Schedulers.io())
            .flatMapCompletable { repositoryDao.saveFavorites(it) }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                if (::presenterListener.isInitialized)presenterListener
                    .onMessage("save ok")
            },{
                Timber.tag(NewsUseCase::class.simpleName).e(it)
                if (::presenterListener.isInitialized)presenterListener
                    .onMessage(
                        ErrorType.ERROR.type.plus(" ")
                        .plus(it.message))
            }))
    }

    override fun startCase() {

    }

    override fun stopCase() {
       if (!disposable.isDisposed) disposable.dispose()
    }
}