package com.arch.featurelocalstorage.entry

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.arch.featurelocalstorage.BuildConfig


@Entity(tableName = "entry")
class Entry( val name: String?,val author : String?,
    val title : String?,val description: String?,val url: String?,val urlToImage: String?,val publishedAt: String?) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0


    override fun toString(): String {
        return if (BuildConfig.DEBUG)  super.toString() else ""
    }
}