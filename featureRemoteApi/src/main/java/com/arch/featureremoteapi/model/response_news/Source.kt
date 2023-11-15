package com.arch.featureremoteapi.model.response_news

import com.arch.featureremoteapi.BuildConfig
import com.google.gson.annotations.SerializedName

class Source(
    @field:SerializedName("id") var id: Any?,
    @field:SerializedName("name") var name: String?
) {

    override fun toString(): String {
        return if (BuildConfig.DEBUG)"Source{" +
                "mId=" + id +
                ", mName='" + name + '\'' +
                '}' else ""
    }
}