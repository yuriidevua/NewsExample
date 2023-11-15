package com.arch.presentation.base

interface BasePresenter {
    fun startView()
    fun stopView()
    fun pauseView()
    fun destroyView()
}