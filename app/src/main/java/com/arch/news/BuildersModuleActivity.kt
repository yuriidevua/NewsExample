package com.arch.news

import com.arch.news.module_activity.ModuleMainActivity
import com.arch.news.scope.ActivityScope
import com.arch.presentation.activity.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class BuildersModuleActivity {
    @ActivityScope
    @ContributesAndroidInjector(modules = [ModuleMainActivity::class, BuildersModuleFragment::class])
    abstract fun bindMapActivity(): com.arch.presentation.activity.MainActivity
}