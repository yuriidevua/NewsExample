package com.arch.presentation.fragment.web

import com.arch.portdomain.model.NewsModel
import com.arch.presentation.base.BasePresenter

interface IWeb {
    interface View {
        fun shareLink()
        fun showMessage(message: String)
    }

    interface Presenter : BasePresenter{
        fun init(news: NewsModel)
        fun closedWebFragment()
        fun menu()
        fun saveNews()
        fun shareContent()
    }
}