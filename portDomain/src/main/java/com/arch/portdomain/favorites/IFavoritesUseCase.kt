package com.arch.portdomain.favorites

import com.arch.portdomain.Interactor
import com.arch.portdomain.model.NewsModel

interface IFavoritesUseCase {
    interface UseCaseFavorites : Interactor{
        fun initListener(listener : IFavoritesUseCase.PresenterListener)
        fun loadLocalNews()

        fun deleteFavoritesLocale(news : NewsModel)
    }

    interface PresenterListener {
        fun listenerFavoritesPresenter(list : List<NewsModel>)

        fun successDeleteFavorites(news: NewsModel)

        fun onMessage(message : String)
    }
}