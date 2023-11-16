package com.arch.featurelocalstorage.entry

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.arch.featurelocalstorage.BuildConfig


@Entity(tableName = "entry")
class Entry(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val name: String?,
    val author: String?,
    val title: String?,
    val description: String?,
    val url: String?,
    @ColumnInfo(name = "url_to_image")val urlToImage: String?,
    @ColumnInfo(name = "published_at")val publishedAt: String?
) {

    override fun toString(): String {
        return if (BuildConfig.DEBUG) super.toString() else ""
    }
}