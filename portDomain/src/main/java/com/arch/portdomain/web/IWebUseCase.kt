package com.arch.portdomain.web

import com.arch.portdomain.Interactor
import com.arch.portdomain.model.NewsModel

interface IWebUseCase {
    interface UseCaseWeb : Interactor{
        fun initListener(listener : IWebUseCase.PresenterListener)
        fun saveNews(news: NewsModel)
    }

    interface PresenterListener{
        fun successSave()

        fun onMessage(message : String)
    }
}