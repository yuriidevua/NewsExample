package com.arch.presentation.activity

import com.arch.presentation.base.BasePresenter
import com.arch.presentation.base.BaseViewActivityContract

interface IMainView {
    interface View : BaseViewActivityContract {

    }

    interface Presenter : BasePresenter {
        fun startExampleDialog()
    }
}