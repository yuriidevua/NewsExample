package com.arch.presentation.fragment.favorites

import com.arch.portdomain.model.NewsModel
import com.arch.presentation.base.BasePresenter


interface IFavoritesNews {
    interface View {
        fun shareLink(url: String)

        fun showMessage(message: String)

        fun displayNews(list: List<NewsModel>)

        fun notifyItemChanged(position: Int, size: Int)
    }

    interface Presenter : BasePresenter{
        fun init()

        fun shareLink(position: Int)

        fun deleteNewsLocale(news: NewsModel, position: Int)

        fun selectedNews(position: Int)

        fun menu()

        fun utilTime(time: String?): String?
    }
}