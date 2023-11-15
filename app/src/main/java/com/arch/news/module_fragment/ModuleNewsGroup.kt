package com.arch.news.module_fragment

import com.arch.domain.news_group.GroupUseCase
import com.arch.news.scope.FragmentScope
import com.arch.portdomain.news_group.IGroupsUseCase
import com.arch.presentation.fragment.group.INewsGroup
import com.arch.presentation.fragment.group.NewsGroup
import com.arch.presentation.fragment.group.NewsGroupPresenter
import dagger.Binds
import dagger.Module

@Module
abstract class ModuleNewsGroup {
    @FragmentScope
    @Binds
    abstract fun bindNewsGroupView(view : NewsGroup) : INewsGroup.View

    @FragmentScope
    @Binds
    abstract fun bindNewsGroupPresenter(presenter: NewsGroupPresenter) : INewsGroup.Presenter

    @FragmentScope
    @Binds
    abstract fun bindUseCaseGroup(useCase: GroupUseCase) : IGroupsUseCase.UseCaseGroup
}