package com.arch.presentation.fragment.web

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import com.arch.portdomain.model.NewsModel
import com.arch.presentation.R
import com.arch.presentation.base.BaseFragment
import com.arch.presentation.base.BasePresenter
import com.arch.presentation.databinding.FragmentWebBinding
import com.arch.presentation.fragment.news.News
import javax.inject.Inject


class WebFragment : BaseFragment<FragmentWebBinding>(),IWeb.View {
    @Inject
    lateinit var presenter: IWeb.Presenter
    companion object {
        private const val TAG = "model"
        @JvmStatic
        fun newInstance(newsModel: NewsModel) =
            WebFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(TAG,newsModel)
                }
            }
    }

    override fun getPresenter(): BasePresenter = presenter

    override val layoutRes: Int = R.layout.fragment_web

    @SuppressLint("NewApi")
    override fun initFragmentView() {
        binding.event = presenter
        if (arguments != null) {

            val newsModel = arguments?.getParcelable<NewsModel>(TAG) as NewsModel
            if (newsModel != null) {
                binding.item = newsModel
                if (newsModel.id != 0L) binding.ivWebFavorites.visibility = View.GONE
                newsModel.url?.let { setupBrowser(it)} ?:  presenter.closedWebFragment()
                binding.ivWebShare.setOnClickListener {
                    val sendIntent = Intent()
                    sendIntent.action = Intent.ACTION_SEND
                    sendIntent.putExtra(Intent.EXTRA_TEXT, binding.wvsWeb.url)
                    sendIntent.type = "text/plain"
                    startActivity(sendIntent)
                }
            }else{
                presenter.closedWebFragment()
            }
        }
    }

    private fun setupBrowser(url: String) {
        val webSettings: WebSettings = binding.wvsWeb.settings
        webSettings.javaScriptCanOpenWindowsAutomatically
        binding.wvsWeb.setLayerType(View.LAYER_TYPE_HARDWARE, null)
        webSettings.cacheMode = WebSettings.LOAD_NO_CACHE
        binding.wvsWeb.setLayerType(View.LAYER_TYPE_HARDWARE, null)
        binding.wvsWeb.webViewClient = WebViewClient()
        webChrome()
        binding.wvsWeb.loadUrl(url)
    }

    private fun webChrome() {
        binding.wvsWeb.webChromeClient = object : WebChromeClient() {
            @SuppressLint("UseCompatLoadingForDrawables")
            override fun onProgressChanged(view: WebView, newProgress: Int) {
                if (context != null) {
                    binding.pbWebProgressBar.progress = newProgress
                    binding.pbWebProgressBar.progressDrawable =
                        context?.resources?.getDrawable(R.drawable.progress_indicator,null)
                    binding.pbWebProgressBar.visibility = if (newProgress == 100) View.GONE else View.VISIBLE
                }
            }
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
}