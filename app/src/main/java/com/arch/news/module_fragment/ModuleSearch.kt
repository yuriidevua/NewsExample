package com.arch.news.module_fragment

import com.arch.news.scope.FragmentScope
import com.arch.presentation.fragment.search.ISearch
import com.arch.presentation.fragment.search.Search
import com.arch.presentation.fragment.search.SearchPresenter
import dagger.Binds
import dagger.Module

@Module
abstract class ModuleSearch {
    @FragmentScope
    @Binds
    abstract fun bindSearchView(view : Search) : ISearch.View

    @FragmentScope
    @Binds
    abstract fun bindSearchPresenter(presenter: SearchPresenter) : ISearch.Presenter
}