package com.arch.featureremoteapi


import com.arch.featureremoteapi.api.ApiService
import com.arch.featureremoteapi.api.HttpService
import com.arch.featureremoteapi.model.response_category.ResponseCategory
import com.arch.featureremoteapi.model.response_news.ResponseNews
import io.reactivex.rxjava3.core.Single
import timber.log.Timber


class RemoteStorage : IRemoteStorage{
    private val api : ApiService = HttpService().apiService
    override fun newsLanguage(language: String): Single<ResponseCategory> =
         api.requestLanguage(language)
             .doOnError {Timber.tag(RemoteStorage::class.simpleName).e("error ".plus(it))  }
             .doOnSuccess { Timber.tag(RemoteStorage::class.simpleName).e(it.sources.size.toString())  }

    override fun newsSearch(search: String,dataStart: String,dataEnd: String)
    : Single<ResponseNews> = api.requestSearch(search,dataStart,dataEnd,BuildConfig.API_KEY)


    override fun loadCategory(): Single<ResponseCategory> = api.requestGroup()

    override fun newsChannel(newsChannel: String)
    : Single<ResponseNews> = api.requestNewsChannel(newsChannel)

    override fun newsCountry(newsCountry: String)
    : Single<ResponseNews> = api.requestTopHeadlinesCountry(newsCountry)


}