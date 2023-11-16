package com.arch.news.androidktsskeletonbase

import com.arch.news.androidktsskeletonbase.module_activity.ModuleMainActivity
import com.arch.news.androidktsskeletonbase.scope.ActivityScope
import com.sceleton.presentation.activity.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class BuildersModuleActivity {
    @ActivityScope
    @ContributesAndroidInjector(modules = [ModuleMainActivity::class, BuildersModuleFragment::class])
    abstract fun bindMapActivity(): MainActivity
}