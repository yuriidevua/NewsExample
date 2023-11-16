package com.arch.news.module_fragment

import com.arch.domain.favorites.FavoritesUseCase
import com.arch.news.scope.FragmentScope
import com.arch.portdomain.favorites.IFavoritesUseCase
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

    @FragmentScope
    @Binds
    abstract fun bindFavoritesUseCase(useCase: FavoritesUseCase) : IFavoritesUseCase.UseCaseFavorites
}