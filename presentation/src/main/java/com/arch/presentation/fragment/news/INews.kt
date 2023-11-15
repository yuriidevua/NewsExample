package com.arch.presentation.fragment.news

import com.arch.portdomain.model.ArgObject
import com.arch.portdomain.model.NewsModel
import com.arch.presentation.base.BasePresenter

interface INews {
    interface View {
        fun updateAdapterList(newsList: List<NewsModel>)

        fun shareLink(url: String)

        fun showMessage(message: String)
    }

    interface Presenter : BasePresenter{
        fun init(arg: ArgObject)

        fun selectedNews(news : NewsModel)

        fun saveNews(news : NewsModel)

        fun shareContent(news : NewsModel)
        fun menu()
    }
}