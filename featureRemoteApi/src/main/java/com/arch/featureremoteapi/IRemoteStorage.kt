package com.arch.featureremoteapi

import com.arch.featureremoteapi.model.response_category.ResponseCategory
import com.arch.featureremoteapi.model.response_news.ResponseNews
import io.reactivex.rxjava3.core.Single


interface  IRemoteStorage {
    fun newsLanguage(language: String): Single<ResponseCategory>

    fun newsSearch(search: String, dataStart: String, dataEnd: String): Single<ResponseNews>

    fun loadCategory(): Single<ResponseCategory>

    fun newsChannel(newsChannel: String): Single<ResponseNews>

    fun newsCountry(newsCountry: String): Single<ResponseNews>
}