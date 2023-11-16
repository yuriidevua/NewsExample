package com.arch.presentation.fragment.favorites

import com.arch.portdomain.favorites.IFavoritesUseCase
import com.arch.portdomain.model.NewsModel
import com.arch.presentation.router.ConstRouter
import com.arch.presentation.router.IRouter
import javax.inject.Inject

class NewsFavoritesPresenter @Inject constructor(private val view : IFavoritesNews.View,
    private val router : IRouter,private val useCase: IFavoritesUseCase.UseCaseFavorites)
    : IFavoritesNews.Presenter,IFavoritesUseCase.PresenterListener {
    override fun init() {
        useCase.initListener(this)
        useCase.loadLocalNews()
    }

    override fun shareLink(item: NewsModel) {
        item.url?.let {view.shareLink(it)}
    }


    override fun deleteNewsLocale(news: NewsModel) {
            router.isProgress(true)
            useCase.deleteFavoritesLocale(news)
            view.deleteItemAdapter(news)
    }

    override fun selectedNews(item: NewsModel) {
            router.transaction(ConstRouter.WEB_FRAGMENT.route,item)
    }


    override fun menu() {
        router.openDrawer()
    }

    override fun startView() {

    }

    override fun stopView() {

    }

    override fun pauseView() {

    }

    override fun destroyView() {
        useCase.stopCase()
    }

    override fun listenerFavoritesPresenter(list: List<NewsModel>) {
        view.updateListAdapter(list)
    }

    override fun successDeleteFavorites() {
        router.isProgress(false)
        view.showMessage("delete ok")
    }

    override fun onMessage(message: String) {
        router.isProgress(false)
        view.showMessage(message)
    }
}