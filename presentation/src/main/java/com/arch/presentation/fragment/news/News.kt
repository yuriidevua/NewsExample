package com.arch.presentation.fragment.news

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.arch.portdomain.model.ArgObject
import com.arch.portdomain.model.NewsModel
import com.arch.presentation.R
import com.arch.presentation.base.BaseFragment
import com.arch.presentation.base.BasePresenter
import com.arch.presentation.databinding.FragmentNewsBinding
import com.arch.presentation.fragment.group.adapter.lang.NewsLanguageAdapter
import com.arch.presentation.fragment.news.adapter.NewsAdapter
import javax.inject.Inject


class News : BaseFragment<FragmentNewsBinding>(), INews.View{
    private lateinit var adapter : NewsAdapter
    @Inject
    lateinit var presenter: INews.Presenter

    companion object {
        const val TAG = "tag"
        @JvmStatic
        fun newInstance(argModel : ArgObject) =
            News().apply {
                arguments = Bundle().apply {
                    putParcelable(TAG,argModel)
                }
            }
    }

    override fun getPresenter(): BasePresenter = presenter


    override val layoutRes: Int = R.layout.fragment_news

    @SuppressLint("NewApi")
    override fun initFragmentView() {
        binding.event = presenter
        displayNewsInit()
            if (arguments != null ) {
               val argObject = arguments?.getParcelable(TAG, ArgObject::class.java)
               if (argObject != null) presenter.init(argObject)
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

     private fun displayNewsInit() {
         binding.rvNewsDisplay.layoutManager =
             LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
         adapter = NewsAdapter(presenter)
         binding.rvNewsDisplay.adapter = adapter
    }

    override fun updateAdapterList(newsList: List<NewsModel>) {
       adapter.updateList(newsList)
    }


}