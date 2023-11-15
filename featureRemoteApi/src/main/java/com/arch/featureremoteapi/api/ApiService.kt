package com.arch.featureremoteapi.api

import com.arch.featureremoteapi.BuildConfig
import com.arch.featureremoteapi.model.response_category.ResponseCategory
import com.arch.featureremoteapi.model.response_news.ResponseNews
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiService {
    @Headers("Authorization:${BuildConfig.API_KEY}")
    @GET("/v2/top-headlines")
    fun requestTopHeadlinesCountry(
        @Query("country") country: String
    ): Single<ResponseNews>

    @GET("/v2/everything")
    fun requestSearch(
        @Query(value = "q", encoded = true) query: String,
        @Query(value = "from", encoded = true) from: String,
        @Query(value = "to", encoded = true) to: String,
        @Query(value = "apiKey", encoded = true) authorization: String
    ): Single<ResponseNews>
    @Headers("Authorization:${BuildConfig.API_KEY}")
    @GET("/v2/top-headlines")
    fun requestNewsChannel(
        @Query(value = "sources", encoded = true) sources: String
    ): Single<ResponseNews>
    @Headers("Authorization:${BuildConfig.API_KEY}")
    @GET("/v2/sources")
    fun requestGroup(): Single<ResponseCategory>
    @Headers("Authorization:${BuildConfig.API_KEY}")
    @GET("/v2/sources")
    fun requestLanguage(
        @Query("language") language: String,
    ): Single<ResponseCategory>
}