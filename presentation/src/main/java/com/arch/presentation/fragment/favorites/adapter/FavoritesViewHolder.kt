package com.arch.presentation.fragment.favorites.adapter

import android.view.View
import com.arch.portdomain.model.NewsModel
import com.arch.presentation.base.BaseViewHolder
import com.arch.presentation.databinding.ItemFavoritesBinding
import com.arch.presentation.fragment.favorites.IFavoritesNews
import com.arch.presentation.glide.GlideApp
import com.arch.presentation.util.StringUtils

class FavoritesViewHolder constructor(private val view : View,private val presenter : IFavoritesNews.Presenter)
    : BaseViewHolder<ItemFavoritesBinding>(view)  {

    init {
        binding?.let { it.event = presenter }
    }

    fun bind(item : NewsModel){
        binding?.let {bind ->
            bind.item = item
            item.urlToImage?.let {
                GlideApp.with(view)
                    .load(it)
                    .into(bind.ivItemFavoritesImage)
            }
            item.title?.let { bind.tvItemFavoritesTitle.text = it}
            item.description?.let { bind.tvItemFavoritesDescription.text = it}
            item.publishedAt?.let { bind.tvFavoritesTime.text = StringUtils.dateFormat(it) }
        }
    }
}