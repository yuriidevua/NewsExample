package com.arch.presentation.fragment.group

import com.arch.portdomain.model.ArgObject
import com.arch.portdomain.model.NewsGroupModel
import com.arch.portdomain.news_group.IGroupsUseCase
import com.arch.presentation.router.ConstRouter
import com.arch.presentation.router.IRouter
import com.arch.presentation.util.Language
import javax.inject.Inject

class NewsGroupPresenter @Inject constructor(
    val router: IRouter,
    private val useCase: IGroupsUseCase.UseCaseGroup,
    private val view: INewsGroup.View
) : INewsGroup.Presenter,
    IGroupsUseCase.PresenterListener {
    override fun init() {
        Language.flag = Language.ALL
        useCase.loadCategory()
    }

    override fun selectedItem(model: NewsGroupModel) {
        model.id?.let { router.transaction(ConstRouter.NEWS_FRAGMENT.route,
            ArgObject(ConstRouter.ARG_NEWS.route, news = it))}
    }

    override fun callMenu() {
        router.openDrawer()
    }

    override fun onClickLanguage(lang: String) {
        if (lang == Language.ALL) useCase.loadCategory()
        else useCase.selectLanguage(lang)
        view.updateAdapterLang()
    }

    override fun startView() {
        useCase.initListenerPresenter(this)
    }

    override fun stopView() {

    }

    override fun pauseView() {

    }

    override fun destroyView() {
        useCase.stopCase()
    }

    override fun listenerGroupInteractor(listGroup: List<NewsGroupModel>) {
        view.updateItemAdapter(listGroup)
    }

    override fun onMessage(message: String) {
        view.showMessage(message)
    }
}