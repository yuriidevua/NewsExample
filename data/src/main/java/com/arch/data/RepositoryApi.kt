package com.arch.data

import com.arch.featureremoteapi.IRemoteStorage
import com.arch.featureremoteapi.RemoteStorage
import com.arch.portdata.IRepositoryApi
import com.arch.portdata.model.DataGroup
import com.arch.portdata.model.DataNews
import io.reactivex.rxjava3.core.Single
import timber.log.Timber

class RepositoryApi : BaseRepApi(), IRepositoryApi {
    private val remoteStorage : IRemoteStorage
    init {
        remoteStorage = RemoteStorage()
    }
    override fun newsLanguage(language: String): Single<List<DataGroup>> =
        remoteStorage.newsLanguage(language)
            .flatMap {mapperFromGroup(it)}
            .doOnError{Timber.tag(RepositoryApi::class.simpleName).e(it)}

    override fun newsSearch(search: String, dataStart: String, dataEnd: String):
            Single<List<DataNews>> = remoteStorage.newsSearch(search,dataStart,dataEnd)
        .flatMap {mapperFromNews(it)}
        .doOnError{Timber.tag(RepositoryApi::class.simpleName).e(it)}

    override fun loadCategory(): Single<List<DataGroup>> = remoteStorage.loadCategory()
        .flatMap {mapperFromGroup(it)}
        .doOnError{Timber.tag(RepositoryApi::class.simpleName).e(it)}

    override fun newsChannel(newsChannel: String): Single<List<DataNews>> =
        remoteStorage.newsChannel(newsChannel)
        .flatMap {mapperFromNews(it)}
        .doOnError{Timber.tag(RepositoryApi::class.simpleName).e(it)}

    override fun newsCountry(newsCountry: String): Single<List<DataNews>> =
        remoteStorage.newsCountry(newsCountry)
            .flatMap {mapperFromNews(it)}
            .doOnError{Timber.tag(RepositoryApi::class.simpleName).e(it)}
}