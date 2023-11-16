package com.arch.data

import com.arch.featurelocalstorage.entry.Entry
import com.arch.portdata.model.DataNews
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

abstract class BaseDAO {

    fun mapperToEntry(data: DataNews): Single<Entry> =
        Single.just(data)
            .map {
                Entry(
                    id = it.id,
                    name = it.name,
                    author = it.author,
                    title = it.title,
                    description = it.description,
                    urlToImage = it.urlToImage,
                    url = it.url,
                    publishedAt = it.publishedAt
                )
            }

    fun mapperToData(entryList: List<Entry>): Single<List<DataNews>> =
        Single.just(entryList)
            .flatMapObservable { Observable.fromIterable(it) }
            .map {
                val data = DataNews(
                    name = it.name,
                    author = it.author,
                    title = it.title,
                    description = it.description,
                    url = it.url,
                    urlToImage = it.urlToImage,
                    publishedAt = it.publishedAt
                )
                data.id = it.id
                return@map data
            }.toList()


}