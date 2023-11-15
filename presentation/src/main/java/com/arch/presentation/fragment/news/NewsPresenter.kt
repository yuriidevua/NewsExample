package com.arch.presentation.fragment.news

import com.arch.portdomain.model.ArgObject
import com.arch.portdomain.model.NewsModel
import com.arch.portdomain.news.INewsUseCase
import com.arch.presentation.router.ConstRouter
import com.arch.presentation.router.IRouter
import javax.inject.Inject

class NewsPresenter @Inject constructor(
    private val view: INews.View, private val router: IRouter,
    private val useCase: INewsUseCase.UseCaseNews
) : INews.Presenter, INewsUseCase.PresenterListener {
    override fun init(arg: ArgObject) {
        when (arg.cmd) {
            ConstRouter.ARG_NEWS.route -> useCase.loadNewsChannel(arg.news)
            ConstRouter.ARG_COUNTRY.route -> useCase.loadNewsCountry(arg.country)
            ConstRouter.ARG_SEARCH.route -> useCase.loadNewsSearch(arg.news,arg.dateFrom,arg.dateTo)
        }
    }

    override fun selectedNews(news: NewsModel) {
        router.transaction(ConstRouter.WEB_FRAGMENT.route,news)
    }

    override fun saveNews(news: NewsModel) {
        useCase.saveNews(news)
    }

    override fun shareContent(news: NewsModel) {
       news.url?.let { view.shareLink(it)}
    }

    override fun menu() {
        router.openDrawer()
    }

    override fun startView() {
        useCase.initListener(this)
    }

    override fun stopView() {

    }

    override fun pauseView() {

    }

    override fun destroyView() {

    }

    override fun listenerNewsPresenter(list: List<NewsModel>) {
        view.updateAdapterList(list)
    }

    override fun onMessage(message: String) {
        view.showMessage(message)
    }
}