package com.arch.presentation.fragment.favorites

import com.arch.portdomain.model.NewsModel
import com.arch.presentation.R
import com.arch.presentation.base.BaseFragment
import com.arch.presentation.base.BasePresenter
import com.arch.presentation.databinding.FragmentNewsFavoritesBinding
import javax.inject.Inject


class NewsFavorites : BaseFragment<FragmentNewsFavoritesBinding>(), IFavoritesNews.View {
   @Inject
   lateinit var presenter: IFavoritesNews.Presenter
    companion object {
        @JvmStatic
        fun newInstance() = NewsFavorites()
    }

    override fun getPresenter(): BasePresenter = presenter

    override val layoutRes: Int = R.layout.fragment_news_favorites

    override fun initFragmentView() {

    }

    override fun attachFragment() {

    }

    override fun startFragment() {

    }

    override fun stopFragment() {

    }

    override fun destroyFragment() {

    }

    override fun pauseFragment() {

    }

    override fun resume() {

    }

    override fun displayNews(list: List<NewsModel>) {

    }

    override fun notifyItemChanged(position: Int, size: Int) {

    }
}