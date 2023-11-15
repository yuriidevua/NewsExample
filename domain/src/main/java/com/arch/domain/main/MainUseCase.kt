package com.arch.domain.main

import com.arch.domain.BaseInteractor
import com.arch.portdata.IRepositoryDAO
import com.arch.portdomain.main.IMainUseCase
import javax.inject.Inject

class MainUseCase @Inject constructor(repositoryDAO: IRepositoryDAO) : BaseInteractor(),
    IMainUseCase {
    override fun startCase() {

    }

    override fun stopCase() {

    }
}