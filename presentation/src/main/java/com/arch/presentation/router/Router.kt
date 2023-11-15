package com.arch.presentation.router

import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.arch.portdomain.model.ArgObject
import com.arch.portdomain.model.NewsModel
import com.arch.presentation.base.BaseViewActivityContract
import com.arch.presentation.fragment.favorites.NewsFavorites
import com.arch.presentation.fragment.group.NewsGroup
import com.arch.presentation.fragment.news.News
import com.arch.presentation.fragment.search.Search
import com.arch.presentation.fragment.web.WebFragment
import dagger.android.support.DaggerAppCompatActivity
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class Router @Inject constructor(
    private val view: BaseViewActivityContract,
    activity: DaggerAppCompatActivity) : BaseRouter(activity), IRouter {
    private lateinit var mDrawerLayout: DrawerLayout
    override fun init(drawerLayout: DrawerLayout) {
        mDrawerLayout = drawerLayout

    }

    override fun onStartView() {

    }

    override fun activeBackStack(flag: Boolean) {

    }

    override fun onBackPressed() = super.backPressedRouter()



    override fun dialogTransaction(cmd: String): Single<Int> {
        return TODO("Not Used")
    }

    override fun setAppBarText(name: String) = view.setAppBarText(name)

    override fun hideAppBar(state: Boolean) = view.hideAppBar(state)

    override fun hideBottomNavigation(flag: Boolean) = view.hideBottomNavigation(flag)

    override fun onStopView() {

    }

    override fun transaction(cmd: String, obj: Any) {
        when (cmd) {
            ConstRouter.NEWS_GROUP_FRAGMENT.route ->
                super.transactionFragmentWithBackStack(NewsGroup.newInstance(), content())
            ConstRouter.NEWS_FRAGMENT.route ->
                if (obj is ArgObject)super.transactionFragmentWithBackStack(News.newInstance(obj), content())
            ConstRouter.FAVORITES_NEWS_FRAGMENT.route ->
                super.transactionFragmentWithBackStack(NewsFavorites.newInstance(),content())
            ConstRouter.SEARCH_FRAGMENT.route ->
                super.transactionFragmentWithBackStack(Search.newInstance(),content())
            ConstRouter.WEB_FRAGMENT.route ->
               if (obj is NewsModel) super.transactionFragmentWithBackStack(WebFragment.newInstance(obj),content())

        }
    }

    override fun transaction(cmd: String) {
        transaction(cmd, "")
    }


    override fun restartApp() = super.restartAppBase()

    override fun isProgress(flag: Boolean) = view.isProgress(flag)


    override fun removeAllFrag() {
        super.removeAllFragment()
    }


    override fun openDrawer() = mDrawerLayout.openDrawer(GravityCompat.START)

    override fun closeDrawer() = mDrawerLayout.closeDrawers().also {

    }

    override fun navDrawer(cmd: String) {
        closeDrawer()
        when (cmd) {
            ConstRouter.MAIN_DRAW.route -> transaction(ConstRouter.NEWS_GROUP_FRAGMENT.route)
            ConstRouter.FAVORITES_DRAW.route -> transaction(ConstRouter.FAVORITES_NEWS_FRAGMENT.route)
            ConstRouter.SEARCH_DRAW.route -> transaction(ConstRouter.SEARCH_FRAGMENT.route)
        }
    }

    override fun popBackStack() {
        super.popBackStackRouter()
    }

}