package com.arch.news.module_fragment

import com.arch.news.scope.FragmentScope
import com.arch.presentation.fragment.favorites.IFavoritesNews
import com.arch.presentation.fragment.favorites.NewsFavorites
import com.arch.presentation.fragment.favorites.NewsFavoritesPresenter
import dagger.Binds
import dagger.Module

@Module
abstract class ModuleFavorites {
    @FragmentScope
    @Binds
    abstract fun bindFavoritesView(view : NewsFavorites) : IFavoritesNews.View

    @FragmentScope
    @Binds
    abstract fun bindFavoritesPresenter(presenter: NewsFavoritesPresenter) : IFavoritesNews.Presenter
}