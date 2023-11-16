package com.arch.presentation.fragment.web

import com.arch.portdomain.model.NewsModel
import com.arch.portdomain.web.IWebUseCase
import com.arch.presentation.router.IRouter
import javax.inject.Inject

class WebPresenter @Inject constructor(private val view : IWeb.View,
    private val router : IRouter,
    private val useCase : IWebUseCase.UseCaseWeb)
    : IWeb.Presenter,IWebUseCase.PresenterListener {


    override fun closedWebFragment() {

    }

    override fun menu() {
        router.openDrawer()
    }

    override fun saveNews(item : NewsModel) {
            useCase.saveNews(item)
    }


    override fun startView() {
        useCase.initListener(this)
    }

    override fun stopView() {

    }

    override fun pauseView() {

    }

    override fun destroyView() {
        useCase.stopCase()
    }

    override fun successSave() {
        view.showMessage("save ok")
    }

    override fun onMessage(message: String) {
            view.showMessage(message)
    }
}