package com.arch.data

import com.arch.featureremoteapi.model.response_category.ResponseCategory
import com.arch.featureremoteapi.model.response_news.ResponseNews
import com.arch.portdata.model.DataGroup
import com.arch.portdata.model.DataNews
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import timber.log.Timber

abstract class BaseRepApi {
    fun mapperFromGroup(response: ResponseCategory): Single<List<DataGroup>> {
        return Single.just(response)
            .flatMapObservable {Observable.fromIterable(it.sources) }
            .map {
                return@map DataGroup(
                    it.id,
                    it.category,
                    it.country,
                    it.description,
                    it.language,
                    it.name,
                    it.url
                )
            }
            .toList()
    }

    fun mapperFromNews(response: ResponseNews): Single<List<DataNews>> {
        return Single.just(response)
            .flatMapObservable { Observable.fromIterable(it.articles) }
            .map {
                Timber.tag(BaseRepApi::class.java.simpleName)
                    .e("response %s",it)
                DataNews(it.source?.name,it.author,it.title,
                    it.description,it.url,it.urlToImage,it.publishedAt)
            }
            .toList()
    }


}