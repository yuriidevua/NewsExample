package com.arch.presentation.fragment.web

import android.os.Bundle
import com.arch.portdomain.model.NewsModel
import com.arch.presentation.R
import com.arch.presentation.base.BaseFragment
import com.arch.presentation.base.BasePresenter
import com.arch.presentation.databinding.FragmentWebBinding
import javax.inject.Inject


class WebFragment : BaseFragment<FragmentWebBinding>(),IWeb.View {
    @Inject
    lateinit var presenter: IWeb.Presenter
    companion object {
        @JvmStatic
        fun newInstance(newsModel: NewsModel) =
            WebFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }

    override fun getPresenter(): BasePresenter = presenter

    override val layoutRes: Int = R.layout.fragment_web

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

    override fun shareLink() {
        TODO("Not yet implemented")
    }

}