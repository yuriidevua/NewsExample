package com.arch.featureremoteapi.model.response_category

import com.arch.featureremoteapi.BuildConfig
import com.google.gson.annotations.SerializedName

class ResponseCategory {
    @SerializedName("sources")
    var sources: List<Source> = ArrayList()

    @SerializedName("status")
    var status: String? = null
    override fun toString(): String {
        return if (BuildConfig.DEBUG) "ResponseCategory{" +
                "mSources=" + sources +
                ", mStatus='" + status + '\'' +
                '}' else ""
    }
}