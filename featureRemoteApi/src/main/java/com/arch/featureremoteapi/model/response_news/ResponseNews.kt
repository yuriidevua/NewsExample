package com.arch.featureremoteapi.model.response_news

import com.arch.featureremoteapi.BuildConfig
import com.google.gson.annotations.SerializedName

class ResponseNews(
    @field:SerializedName("status") var status: String,
    @field:SerializedName("totalResults") var totalResults: Long
) {
    @SerializedName("articles")
    var articles: List<Article> = ArrayList()

    override fun toString(): String {
        return if (BuildConfig.DEBUG)"ResponseNews{" +
                "mArticles=" + articles +
                ", mStatus='" + status + '\'' +
                ", mTotalResults=" + totalResults +
                '}' else ""
    }
}