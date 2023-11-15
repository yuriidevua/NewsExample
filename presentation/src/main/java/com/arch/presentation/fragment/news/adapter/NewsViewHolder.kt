package com.arch.presentation.fragment.news.adapter

import android.content.Context
import android.view.View
import com.arch.portdomain.model.NewsModel
import com.arch.presentation.base.BaseViewHolder
import com.arch.presentation.databinding.ItemNewsBinding
import com.arch.presentation.fragment.news.INews
import com.arch.presentation.glide.GlideApp
import com.arch.presentation.util.StringUtils

class NewsViewHolder constructor(val context : Context,val view : View,
                                 val presenter: INews.Presenter)
    : BaseViewHolder<ItemNewsBinding>(view) {
    init {
        binding?.let { it.event = presenter }
    }

    fun bind(item : NewsModel, position : Int){
        binding?.let {
            item.urlToImage?.let {urlToImage ->
                GlideApp.with(view)
                    .load(urlToImage)
                    .into(it.ivItemNewsImage)
            }
            item.title?.let {title -> it.tvItemNewsTitle.text = title}
            item.description?.let {description -> it.tvItemNewsDescription.text = description}
            item.publishedAt?.let {publishedAt ->
                it.tvNewsTime.text = StringUtils.dateFormat(publishedAt)}
            it.clNewItem.setOnClickListener{
                presenter.selectedNews(item)
            }
            it.ivItemNewsFavorites.setOnClickListener {
                presenter.saveNews(item)
            }
            it.ivNewsShare.setOnClickListener {
                presenter.shareContent(item)
            }
        }
    }
}