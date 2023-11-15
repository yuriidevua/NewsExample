package com.arch.portdomain.news_group


import com.arch.portdomain.Interactor
import com.arch.portdomain.model.NewsGroupModel

interface IGroupsUseCase {

    interface UseCaseGroup : Interactor {
        fun initListenerPresenter(listener : PresenterListener)
        fun loadCategory()
        fun selectLanguage(language : String)
    }

    interface PresenterListener{
        fun listenerGroupInteractor(listGroup : List<NewsGroupModel>)
        fun onMessage(message : String)
    }
}