package com.arch.presentation.fragment.group

import com.arch.portdomain.model.NewsGroupModel
import com.arch.presentation.base.BasePresenter

interface INewsGroup {
    interface View {
        fun updateItemAdapter(list: List<NewsGroupModel>)

        fun updateAdapterLang()

        fun displayLanguage()

        fun showMessage(message: String)
    }

    interface Presenter : BasePresenter{
        fun init()

        fun selectedItem(model: NewsGroupModel)

        fun callMenu()

        fun onClickLanguage(lang: String)
    }
}