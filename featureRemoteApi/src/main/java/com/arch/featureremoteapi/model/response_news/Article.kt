package com.arch.featureremoteapi.model.response_news

import com.arch.featureremoteapi.BuildConfig
import com.google.gson.annotations.SerializedName

class Article(
    @field:SerializedName("author") var author: String?,
    @field:SerializedName("description") var description: String?,
    @field:SerializedName("publishedAt") var publishedAt: String?,
    @field:SerializedName("source") var source: Source?,
    @field:SerializedName("title") var title: String?,
    @field:SerializedName("url") var url: String?,
    @field:SerializedName("urlToImage") var urlToImage: String?
) {

    override fun toString(): String {
        return if (BuildConfig.DEBUG)"Article{" +
                "mAuthor='" + author + '\'' +
                ", mDescription='" + description + '\'' +
                ", mPublishedAt='" + publishedAt + '\'' +
                ", mSource=" + source +
                ", mTitle='" + title + '\'' +
                ", mUrl='" + url + '\'' +
                ", mUrlToImage='" + urlToImage + '\'' +
                '}' else ""
    }
}