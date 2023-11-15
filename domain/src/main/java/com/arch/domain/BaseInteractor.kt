package com.arch.domain

import android.content.Context
import android.graphics.Bitmap
import com.arch.portdata.model.DataGroup
import com.arch.portdata.model.DataNews
import com.arch.portdomain.model.NewsGroupModel
import com.arch.portdomain.model.NewsModel
import com.bumptech.glide.Glide
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.CompletableTransformer
import io.reactivex.rxjava3.core.FlowableTransformer
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.ObservableTransformer
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.core.SingleTransformer
import io.reactivex.rxjava3.schedulers.Schedulers


abstract class BaseInteractor {
    private var jobThread: Scheduler = Schedulers.io()
    private var observeThread: Scheduler = AndroidSchedulers.mainThread()

    protected open fun <T : Any> applySingleSchedulers(): SingleTransformer<T, T> =
        SingleTransformer {
            it.subscribeOn(jobThread)
                .observeOn(observeThread)
        }

    protected open fun <T : Any> applyFlowableSchedulers(): FlowableTransformer<T, T> =
        FlowableTransformer {
            it.subscribeOn(jobThread)
                .observeOn(observeThread)
        }

    protected open fun <T : Any> applyObservableSchedulers(): ObservableTransformer<T, T> =
        ObservableTransformer {
            it.subscribeOn(jobThread)
                .observeOn(observeThread)
        }

    protected open fun applyCompletableSchedulers(): CompletableTransformer =
        CompletableTransformer {
            it.subscribeOn(jobThread)
                .observeOn(observeThread)
        }

    fun mapperGroup(listGroup: List<DataGroup>): Single<List<NewsGroupModel>> =
        Single.just(listGroup)
            .flatMapObservable { Observable.fromIterable(it) }
            .map {
                NewsGroupModel(
                    it.id,
                    it.category,
                    it.country,
                    it.description,
                    it.language,
                    it.name,
                    it.url)
            }.toList()

    fun mapperNews(listNews: List<DataNews>): Single<List<NewsModel>> =
        Single.just(listNews)
            .flatMapObservable { Observable.fromIterable(it) }
            .map {
                NewsModel(
                    it.id,
                    it.name,
                    it.author,
                    it.title,
                    it.description,
                    it.url,
                    it.urlToImage,
                    it.publishedAt)
            }.toList()

    fun mapperNewsList(news : DataNews) : Single<NewsModel> = Single.just(news)
        .map {  NewsModel(
            it.id,
            it.name,
            it.author,
            it.title,
            it.description,
            it.url,
            it.urlToImage,
            it.publishedAt
        ) }

    fun mapperDataNews(news : NewsModel) : Single<DataNews> = Single.just(news)
        .map {
            val data = DataNews(
                it.name,
                it.author,
                it.title,
                it.description,
                it.url,
                it.urlToImage,
                it.publishedAt)
            data.id = it.id
            return@map data
        }

}