package com.arch.presentation.fragment.group.adapter.news

import android.content.Context
import android.view.View
import com.arch.portdomain.model.NewsGroupModel
import com.arch.presentation.ConstPresentation
import com.arch.presentation.base.BaseViewHolder
import com.arch.presentation.databinding.ItemGroupBinding
import com.arch.presentation.fragment.group.INewsGroup
import com.arch.presentation.glide.GlideApp

import timber.log.Timber

class NewsGroupViewHolder(val context : Context, view : View, val presenter: INewsGroup.Presenter)
    : BaseViewHolder<ItemGroupBinding>(view){

    init {
        binding?.let { it.event = presenter }
    }

    fun bind(item : NewsGroupModel){
        binding?.let {
            item.url?.let { url ->
                GlideApp.with(context)
                    .load(ConstPresentation.LOGO_DOMAIN.const + url + ConstPresentation.SIZE_ICON.const)
                    .circleCrop()
                    .into(it.rivCategoryLogoDomain)
            }
            Timber.e("NewsGroupViewHolder url %s",item)
            item.name?.let {name -> it.tvCategoryDescription.text = name}
            it.contentItem.setOnClickListener {
                presenter.selectedItem(item)
            }
        }

    }
}