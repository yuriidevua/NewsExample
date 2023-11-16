package com.arch.presentation.fragment.favorites

import com.arch.portdomain.model.NewsModel
import com.arch.presentation.base.BasePresenter


interface IFavoritesNews {
    interface View {
        fun shareLink(url: String)

        fun showMessage(message: String)

        fun updateListAdapter(list: List<NewsModel>)

        fun deleteItemAdapter(item: NewsModel)
    }

    interface Presenter : BasePresenter{
        fun init()

        fun shareLink(item: NewsModel)

        fun deleteNewsLocale(news: NewsModel)

        fun selectedNews(item: NewsModel)

        fun menu()
    }
}