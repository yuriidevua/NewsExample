package com.arch.presentation.router

import android.content.Intent
import androidx.fragment.app.FragmentManager
import com.arch.presentation.R
import com.arch.presentation.base.BaseDialogFragment
import dagger.android.support.DaggerAppCompatActivity
import dagger.android.support.DaggerAppCompatDialogFragment
import dagger.android.support.DaggerFragment
import io.reactivex.rxjava3.core.Single


abstract class BaseRouter(private val activity: DaggerAppCompatActivity) {

    protected fun <T : BaseDialogFragment<*>> stepDialog(fragment: T): Single<Int> = Single.defer {
        transactionFragmentDialog(fragment, dagger.android.support.R.id.content)
        Single.create(fragment::setEmitter)
    }
    protected fun transactionFragmentNoBackStack(fragment: DaggerFragment, container: Int) =
        activity.supportFragmentManager.beginTransaction()
            .setCustomAnimations(
                R.anim.fragment_enter, R.anim.fragment_exit,
                R.anim.fragment_pop_enter, R.anim.fragment_pop_exit
            )
            .replace(container, fragment, fragment.javaClass.simpleName)
            .commit()


    protected fun transactionFragmentDialog(fragment: DaggerAppCompatDialogFragment,container: Int) =
        activity.supportFragmentManager.beginTransaction()
            .add(container, fragment, fragment.javaClass.simpleName)
            .commit()


    protected fun closeFragmentDialog(fragment: DaggerAppCompatDialogFragment) =
        activity.supportFragmentManager.beginTransaction()
            .remove(fragment)
            .commit()

    protected fun removeAllFragment() =
        activity.supportFragmentManager.findFragmentById(R.id.content)
            ?.let {
                    activity.supportFragmentManager.beginTransaction()
                    .remove(it)
                    .commit()
            }


    protected fun transactionFragmentWithBackStack(fragment: DaggerFragment, container: Int) =
        activity.supportFragmentManager.beginTransaction()
            .setCustomAnimations(
                R.anim.fragment_enter, R.anim.fragment_exit,
                R.anim.fragment_pop_enter, R.anim.fragment_pop_exit
            )
            .replace(container, fragment, fragment.javaClass.simpleName)
            .addToBackStack(null)
            .commit()


    protected fun transactionActivity(mActivity: Class<*>, cycleFinish: Boolean) =
        Intent(activity, mActivity).let {
            activity.startActivity(it)
            if (cycleFinish) activity.finish()
        }

    protected fun <T> transactionActivity(mActivity: Class<*>, cycleFinish: Boolean, `object`: T?) =
        Intent(activity, mActivity).let {
            activity.startActivity(it)
            //    if (`object` != null) {
            //    if(object instanceof Data){
            //    intent.putExtra("data",(Data)object)
            //   }
            //  }
            if (cycleFinish) activity.finish()
        }

    protected fun backPressedRouter() {
        val manager = activity.supportFragmentManager
        if (manager.backStackEntryCount == 1) {
        } else {
            activity.onBackPressedDispatcher.onBackPressed()
        }
    }

    protected open fun popBackStackRouter() {
        val fm: FragmentManager = activity.supportFragmentManager
        for (i in 0 until fm.backStackEntryCount) {
            if (i == 1) {
            } else {
                fm.popBackStack()
            }
        }
    }


    protected fun restartAppBase() {
        val packageManager = activity.packageManager
        val intent = packageManager.getLaunchIntentForPackage(activity.packageName)
        if (intent != null) {
            val componentName = intent.component
            val mainIntent = Intent.makeRestartActivityTask(componentName)
            activity.startActivity(mainIntent)
            Runtime.getRuntime().exit(0)
        }
    }

    protected fun content() : Int = R.id.content

    fun finishActivity(){
        activity.finish()
    }


}