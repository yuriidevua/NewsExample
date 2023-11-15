package com.arch.news

import com.arch.news.module_fragment.ModuleFavorites
import com.arch.news.module_fragment.ModuleNews
import com.arch.news.module_fragment.ModuleNewsGroup
import com.arch.news.module_fragment.ModuleSearch
import com.arch.news.module_fragment.ModuleWeb
import com.arch.news.scope.FragmentScope
import com.arch.presentation.fragment.favorites.NewsFavorites
import com.arch.presentation.fragment.group.NewsGroup
import com.arch.presentation.fragment.news.News
import com.arch.presentation.fragment.search.Search
import com.arch.presentation.fragment.web.WebFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class BuildersModuleFragment {

    @FragmentScope
    @ContributesAndroidInjector(modules = [ModuleNewsGroup::class])
    abstract fun bindNewsGroupFragment() : NewsGroup

    @FragmentScope
    @ContributesAndroidInjector(modules = [ModuleNews::class])
    abstract fun bindNewsFragment() : News

    @FragmentScope
    @ContributesAndroidInjector(modules = [ModuleFavorites::class])
    abstract fun bindFavoritesFragment() : NewsFavorites

    @FragmentScope
    @ContributesAndroidInjector(modules = [ModuleSearch::class])
    abstract fun bindSearchFragment() : Search

    @FragmentScope
    @ContributesAndroidInjector(modules = [ModuleWeb::class])
    abstract fun bindWebFragment() : WebFragment

}