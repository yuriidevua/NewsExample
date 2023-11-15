package com.arch.featureremoteapi.model.response_category

import com.arch.featureremoteapi.BuildConfig
import com.google.gson.annotations.SerializedName

class Source(
    @field:SerializedName("category") var category: String?,
    @field:SerializedName("country") var country: String?,
    @field:SerializedName("description") var description: String?,
    @field:SerializedName("id") var id: String?,
    @field:SerializedName("language") var language: String?,
    @field:SerializedName("name") var name: String?,
    @field:SerializedName("url") var url: String?){
    override fun toString(): String {
        return if (BuildConfig.DEBUG)super.toString() else ""
    }
}