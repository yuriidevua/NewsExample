package com.arch.portdata

import com.arch.portdata.model.DataGroup
import com.arch.portdata.model.DataNews
import io.reactivex.rxjava3.core.Single

interface IRepositoryApi {
    fun newsLanguage(language: String): Single<List<DataGroup>>

    fun newsSearch(search: String, dataStart: String, dataEnd: String): Single<List<DataNews>>

    fun loadCategory(): Single<List<DataGroup>>

    fun newsChannel(newsChannel: String): Single<List<DataNews>>

    fun newsCountry(newsCountry: String): Single<List<DataNews>>
}