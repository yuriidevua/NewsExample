package com.arch.presentation.fragment.favorites

import androidx.recyclerview.widget.LinearLayoutManager
import com.arch.portdomain.model.NewsModel
import com.arch.presentation.R
import com.arch.presentation.base.BaseFragment
import com.arch.presentation.base.BasePresenter
import com.arch.presentation.databinding.FragmentNewsFavoritesBinding
import com.arch.presentation.fragment.favorites.adapter.FavoritesAdapter
import javax.inject.Inject


class NewsFavorites : BaseFragment<FragmentNewsFavoritesBinding>(), IFavoritesNews.View {
   private lateinit var adapter : FavoritesAdapter
   @Inject
   lateinit var presenter: IFavoritesNews.Presenter
    companion object {
        @JvmStatic
        fun newInstance() = NewsFavorites()
    }

    override fun getPresenter(): BasePresenter = presenter

    override val layoutRes: Int = R.layout.fragment_news_favorites

    override fun initFragmentView() {
       binding.event = presenter
       initAdapter()
       presenter.init()
    }

   private fun initAdapter(){
    binding.rvFavoritesDisplay.layoutManager =
     LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    adapter = FavoritesAdapter(presenter)
    binding.rvFavoritesDisplay.adapter = adapter
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

 override fun updateListAdapter(list: List<NewsModel>) {
    adapter.updateListAdapter(list)
 }

 override fun deleteItemAdapter(item: NewsModel) {
   adapter.deleteItem(item)
 }


}