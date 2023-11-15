package com.arch.news.module_activity


import com.arch.news.scope.ActivityScope
import com.arch.domain.main.MainUseCase
import com.arch.portdomain.main.IMainUseCase
import com.arch.presentation.activity.MainActivity
import com.arch.presentation.activity.MainPresenter
import com.arch.presentation.router.IRouter
import com.arch.presentation.router.Router
import com.tbruyelle.rxpermissions3.RxPermissions
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class ModuleMainActivity {
    @ActivityScope
    @Binds
    abstract fun bindsMainView(view : com.arch.presentation.activity.MainActivity) : com.arch.presentation.activity.IMainView.View
    @ActivityScope
    @Binds
    abstract fun bindsMainPresenter(presenter : MainPresenter) : com.arch.presentation.activity.IMainView.Presenter
    companion object{
        @ActivityScope
        @Provides
        fun providesRouter(activity: MainActivity) :
                IRouter = Router(view = activity,activity = activity)
        @ActivityScope
        @Provides
        fun providePermissions(activity: MainActivity): RxPermissions = RxPermissions(activity)
    }
    @ActivityScope
    @Binds
    abstract fun bindMainUseCase(useCase: MainUseCase) : IMainUseCase
}