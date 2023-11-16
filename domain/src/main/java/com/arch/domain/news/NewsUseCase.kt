package com.arch.domain.news

import com.arch.comm.ErrorType
import com.arch.domain.BaseInteractor
import com.arch.portdata.IRepositoryApi
import com.arch.portdata.IRepositoryDAO
import com.arch.portdomain.model.NewsModel
import com.arch.portdomain.news.INewsUseCase
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

class NewsUseCase @Inject constructor(
    private val repositoryApi: IRepositoryApi,
    private val repositoryDao: IRepositoryDAO
) : BaseInteractor(), INewsUseCase.UseCaseNews {
    private lateinit var presenterListener : INewsUseCase.PresenterListener
    private val disposable = CompositeDisposable()
    override fun initListener(listener: INewsUseCase.PresenterListener) {
       presenterListener = listener
    }

    override fun loadNewsChannel(newsChannel: String) {
        disposable.add(Single.defer { repositoryApi.newsChannel(newsChannel) }
            .subscribeOn(Schedulers.io())
            .flatMap { mapperNews(it) }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                if (::presenterListener.isInitialized) presenterListener.listenerNewsPresenter(it)
            },{
                Timber.tag(NewsUseCase::class.simpleName).e(it)
                if (::presenterListener.isInitialized) presenterListener
                    .onMessage(ErrorType.ERROR.type.plus(" ")
                    .plus(it.message))
            }))
    }

    override fun loadNewsCountry(country: String) {
        disposable.add(Single.defer { repositoryApi.newsCountry(country)}
            .subscribeOn(Schedulers.io())
            .flatMap { mapperNews(it) }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                if (::presenterListener.isInitialized)presenterListener.listenerNewsPresenter(it)
            },{
                Timber.tag(NewsUseCase::class.simpleName).e(it)
                if (::presenterListener.isInitialized)presenterListener
                    .onMessage(ErrorType.ERROR.type.plus(" ")
                    .plus(it.message))
            }))
    }

    override fun loadNewsSearch(newSearch: String, dateFrom: String, dateTo: String) {
        disposable.add(Single.defer { repositoryApi.newsSearch(newSearch,dateFrom,dateTo)}
            .subscribeOn(Schedulers.io())
            .flatMap { mapperNews(it) }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                if (::presenterListener.isInitialized) presenterListener.listenerNewsPresenter(it)
            },{
                Timber.tag(NewsUseCase::class.simpleName).e(it)
                if (::presenterListener.isInitialized)presenterListener
                    .onMessage(ErrorType.ERROR.type.plus(" ")
                    .plus(it.message))
            }))
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
                    .onMessage(ErrorType.ERROR.type.plus(" ")
                    .plus(it.message))
            }))
    }

    override fun startCase() {

    }

    override fun stopCase() {
         if (!disposable.isDisposed) disposable.dispose()
    }
}