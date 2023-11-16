package com.arch.news.module_fragment

import com.arch.domain.web.WebUseCase
import com.arch.news.scope.FragmentScope
import com.arch.portdomain.web.IWebUseCase
import com.arch.presentation.fragment.web.IWeb
import com.arch.presentation.fragment.web.WebFragment
import com.arch.presentation.fragment.web.WebPresenter
import dagger.Binds
import dagger.Module

@Module
abstract class ModuleWeb {
    @FragmentScope
    @Binds
    abstract fun bindWebView(view : WebFragment) : IWeb.View

    @FragmentScope
    @Binds
    abstract fun bindWebPresenter(presenter: WebPresenter) : IWeb.Presenter

    @FragmentScope
    @Binds
    abstract fun bindWebUseCase(usecase : WebUseCase) : IWebUseCase.UseCaseWeb
}