package com.arch.presentation.fragment.group

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.arch.portdomain.model.NewsGroupModel
import com.arch.presentation.R
import com.arch.presentation.base.BaseFragment
import com.arch.presentation.base.BasePresenter
import com.arch.presentation.databinding.FragmentNewsGroupBinding
import com.arch.presentation.fragment.group.adapter.lang.NewsLanguageAdapter
import com.arch.presentation.fragment.group.adapter.news.NewsGroupAdapter
import javax.inject.Inject

class NewsGroup : BaseFragment<FragmentNewsGroupBinding>(), INewsGroup.View {
    private lateinit var adapterNewsGroup : NewsGroupAdapter
    private lateinit var adapterLanguage : NewsLanguageAdapter

    @Inject
    lateinit var presenter: INewsGroup.Presenter
    companion object {
        @JvmStatic
        fun newInstance() = NewsGroup()
    }

    override fun getPresenter(): BasePresenter = presenter

    override val layoutRes: Int = R.layout.fragment_news_group

    override fun initFragmentView() {
        binding.event = presenter
        displayLanguage()
        displayGroup()
        presenter.init()
        binding.swipeRefreshRv.setOnRefreshListener {
            presenter.init()
            binding.swipeRefreshRv.isRefreshing = false
        }
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

    private fun displayGroup() {
        binding.rvNewsCategoriesDisplay.layoutManager =
            GridLayoutManager(context, resources.getInteger(R.integer.category_grid_count))
        adapterNewsGroup = NewsGroupAdapter(presenter)
        binding.rvNewsCategoriesDisplay.adapter = adapterNewsGroup
    }

    override fun updateItemAdapter(list: List<NewsGroupModel>) {
        adapterNewsGroup.updateAdapter(list)
    }

    override fun updateAdapterLang() {
        adapterLanguage.updateAdapter()
    }

    override fun displayLanguage() {
        binding.rvNewsCategoryLanguage.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        adapterLanguage = NewsLanguageAdapter(presenter)
        binding.rvNewsCategoryLanguage.adapter = adapterLanguage
    }
}