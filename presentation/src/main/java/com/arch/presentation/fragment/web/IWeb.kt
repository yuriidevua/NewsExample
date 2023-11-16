package com.arch.presentation.fragment.web

import com.arch.portdomain.model.NewsModel
import com.arch.presentation.base.BasePresenter

interface IWeb {
    interface View {

        fun showMessage(message: String)
    }

    interface Presenter : BasePresenter{
        fun closedWebFragment()
        fun menu()
        fun saveNews(item : NewsModel)
    }
}