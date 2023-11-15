package com.arch.portdomain.news

import com.arch.portdomain.Interactor
import com.arch.portdomain.model.NewsModel

interface INewsUseCase {

    interface UseCaseNews : Interactor{
        fun initListener(listener : INewsUseCase.PresenterListener)

        fun loadNewsChannel(newsChannel: String)

        fun loadNewsCountry(country: String)

        fun loadNewsSearch(newSearch: String, dateFrom: String, dateTo: String)

        fun saveNews(news: NewsModel)

    }

    interface PresenterListener{
        fun listenerNewsPresenter(list : List<NewsModel>)

        fun onMessage(message : String)
    }
}