package com.arch.domain.favorites

import com.arch.comm.ErrorType
import com.arch.domain.BaseInteractor
import com.arch.portdata.IRepositoryDAO
import com.arch.portdomain.favorites.IFavoritesUseCase
import com.arch.portdomain.model.NewsModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class FavoritesUseCase @Inject constructor(private val repositoryDao : IRepositoryDAO)
    : BaseInteractor(),IFavoritesUseCase.UseCaseFavorites {
    private lateinit var presenterListener : IFavoritesUseCase.PresenterListener
    private val disposable = CompositeDisposable()
    override fun initListener(listener: IFavoritesUseCase.PresenterListener) {
       presenterListener = listener
    }

    override fun loadLocalNews() {
       disposable.add(Single.defer { repositoryDao.getFavorites() }
           .subscribeOn(Schedulers.io())
           .flatMap { mapperNews(it)}
           .observeOn(AndroidSchedulers.mainThread())
           .subscribe({
                if (::presenterListener.isInitialized) presenterListener.listenerFavoritesPresenter(it)
           },{
               if (::presenterListener.isInitialized)presenterListener
                   .onMessage(
                       ErrorType.ERROR.type.plus(" ")
                       .plus(it.message))
           }))
    }

    override fun deleteFavoritesLocale(news: NewsModel) {
        disposable.add(Single.defer { mapperDataNews(news) }
            .subscribeOn(Schedulers.io())
            .flatMap{ repositoryDao.deleteFavorites(it) }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                if (::presenterListener.isInitialized)presenterListener.successDeleteFavorites()
            },{
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