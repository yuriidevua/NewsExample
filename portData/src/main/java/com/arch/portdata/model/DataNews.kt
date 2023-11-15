package com.arch.portdata.model

data class DataNews(val name: String?,
                    val author: String?,
                    val title: String?,
                    val description: String?,
                    val url: String?,
                    val urlToImage: String?,
                    val publishedAt: String?) {
     var id: Long = 0

}
