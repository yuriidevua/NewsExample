package com.arch.featureremoteapi.api

import android.util.Config
import com.arch.featureremoteapi.BuildConfig
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


class HttpService() {
    val apiService = provideApi(restAdapter(gson(),okHttpClient()))

    private fun okHttpClient(): OkHttpClient {
        val builder = OkHttpClient.Builder()
        if (Config.DEBUG) {
            val logging = HttpLoggingInterceptor()
            logging.setLevel(HttpLoggingInterceptor.Level.BODY)
            builder.addInterceptor(logging)
        }
        builder.connectTimeout((60 * 1000).toLong(), TimeUnit.MILLISECONDS)
            .readTimeout((60 * 1000).toLong(), TimeUnit.MILLISECONDS)
        return builder.build()
    }


    private fun gson(): Gson {
        val gsonBuilder = GsonBuilder()
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        return gsonBuilder
            .setLenient()
            .create()
    }

    private fun restAdapter(gson: Gson, okHttpClient: OkHttpClient): Retrofit {
        val builder = Retrofit.Builder()
        builder.client(okHttpClient)
            .baseUrl(BuildConfig.BASE_URL)
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
        return builder.build()
    }

    private fun provideApi(restAdapter: Retrofit): ApiService {
        return restAdapter.create(ApiService::class.java)
    }
}