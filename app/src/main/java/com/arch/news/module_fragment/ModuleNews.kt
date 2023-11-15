package com.arch.news.module_fragment

import com.arch.domain.news.NewsUseCase
import com.arch.news.scope.FragmentScope
import com.arch.portdomain.news.INewsUseCase
import com.arch.presentation.fragment.news.INews
import com.arch.presentation.fragment.news.News
import com.arch.presentation.fragment.news.NewsPresenter
import dagger.Binds
import dagger.Module

@Module
abstract class ModuleNews {
    @FragmentScope
    @Binds
    abstract fun bindNewsView(view : News) : INews.View

    @FragmentScope
    @Binds
    abstract fun bindNewsPresenter(presenter: NewsPresenter) : INews.Presenter

    @FragmentScope
    @Binds
    abstract fun bindNewsUseCase(useCase: NewsUseCase) : INewsUseCase.UseCaseNews
}