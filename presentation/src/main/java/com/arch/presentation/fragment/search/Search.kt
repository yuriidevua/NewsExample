package com.arch.presentation.fragment.search

import com.arch.presentation.R
import com.arch.presentation.base.BaseFragment
import com.arch.presentation.base.BasePresenter
import com.arch.presentation.databinding.FragmentSearchBinding
import javax.inject.Inject


class Search : BaseFragment<FragmentSearchBinding>(),ISearch.View {
    @Inject
    lateinit var presenter: ISearch.Presenter
    companion object {
        @JvmStatic
        fun newInstance() = Search()
    }

    override fun getPresenter(): BasePresenter = presenter

    override val layoutRes: Int = R.layout.fragment_search

    override fun initFragmentView() {
        TODO("Not yet implemented")
    }

    override fun attachFragment() {
        TODO("Not yet implemented")
    }

    override fun startFragment() {
        TODO("Not yet implemented")
    }

    override fun stopFragment() {
        TODO("Not yet implemented")
    }

    override fun destroyFragment() {
        TODO("Not yet implemented")
    }

    override fun pauseFragment() {
        TODO("Not yet implemented")
    }

    override fun resume() {
        TODO("Not yet implemented")
    }

    override fun searchString(): String {
        TODO("Not yet implemented")
    }

    override fun showDateFrom(date: String) {
        TODO("Not yet implemented")
    }

    override fun showDateTo(date: String) {
        TODO("Not yet implemented")
    }
}