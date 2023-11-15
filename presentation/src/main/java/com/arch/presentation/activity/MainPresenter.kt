package com.arch.presentation.activity

import com.arch.portdomain.main.IMainUseCase
import com.arch.presentation.router.ConstRouter
import com.arch.presentation.router.IRouter
import io.reactivex.rxjava3.disposables.CompositeDisposable
import javax.inject.Inject

class MainPresenter @Inject constructor(private val view : com.arch.presentation.activity.IMainView.View,
                                        private val useCase : IMainUseCase,
                                        private val router : IRouter
) : com.arch.presentation.activity.IMainView.Presenter {
    private val disposable  = CompositeDisposable()
    override fun startExampleDialog() {

    }

    override fun startView() {

    }

    override fun stopView() {
        disposable.clear()
    }

    override fun pauseView() {

    }

    override fun destroyView() {
        disposable.dispose()
    }
}