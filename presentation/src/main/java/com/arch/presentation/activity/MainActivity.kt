package com.arch.presentation.activity

import android.os.Bundle
import android.view.View
import com.arch.presentation.R
import com.arch.presentation.base.BaseActivity
import com.arch.presentation.base.BasePresenter
import com.arch.presentation.databinding.ActivityMainBinding
import com.arch.presentation.router.ConstRouter
import com.arch.presentation.router.IRouter

import javax.inject.Inject

class MainActivity : BaseActivity<ActivityMainBinding>(),
    IMainView.View {
    @Inject
    lateinit var presenter: IMainView.Presenter
    @Inject
    lateinit var router : IRouter

    override val layoutRes: Int = R.layout.activity_main

    override fun initOnCreate() {

    }

    override fun createActivity(savedInstanceState: Bundle?) {
        binding.router = router
        router.init(binding.drawerLayout)
        router.transaction(ConstRouter.NEWS_GROUP_FRAGMENT.route)
    }

    override fun stopActivity() {

    }

    override fun startActivity() {

    }

    override fun pauseActivity() {

    }

    override fun resumeActivity() {

    }

    override fun destroyActivity() {

    }

    override fun getPresenter(): BasePresenter = presenter

    override fun setAppBarText(name: String) {

    }

    override fun hideAppBar(visible: Boolean) {

    }

    override fun onMessage(message: String) {

    }

    override fun isProgress(flag: Boolean) {
        binding.progressBar.visibility = if(flag) View.VISIBLE else View.INVISIBLE
    }

    override fun hideBottomNavigation(flag: Boolean) {

    }
}