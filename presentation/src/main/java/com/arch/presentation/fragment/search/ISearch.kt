package com.arch.presentation.fragment.search

import com.arch.presentation.base.BasePresenter

interface ISearch {
    interface View {
        fun showMessage(message: String)

        fun searchString(): String

        fun showDateFrom(date: String)

        fun showDateTo(date: String)
    }

    interface Presenter : BasePresenter{
        fun onClickDataFrom()

        fun onClickDataTo()

        fun onClickCancel()

        fun onClickOk()

        fun openDrawer()

        fun onClickCountry(position: Int)
    }
}