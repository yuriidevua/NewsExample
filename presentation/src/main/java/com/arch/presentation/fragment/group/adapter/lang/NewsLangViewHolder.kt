package com.arch.presentation.fragment.group.adapter.lang

import android.content.Context
import android.view.View
import com.arch.presentation.R
import com.arch.presentation.base.BaseViewHolder
import com.arch.presentation.databinding.ItemLangBinding
import com.arch.presentation.fragment.group.INewsGroup
import com.arch.presentation.util.Language
import timber.log.Timber

class NewsLangViewHolder(val context : Context, view : View,val presenter: INewsGroup.Presenter )
    : BaseViewHolder<ItemLangBinding>(view){
    init {
        binding?.let { it.event = presenter }
    }

    fun bind(langKey : String, langValue : String){
        binding?.let {
            it.tvItemLanguage.text = langKey
            it.tvItemLanguage.setOnClickListener { _ ->
                Language.flag = langKey
                it.tvItemLanguage.setBackgroundColor(
                    context.resources.getColor(R.color.select_language_ok,null)
                )
                presenter.onClickLanguage(langValue)
            }
            Timber.tag(NewsLangViewHolder::class.simpleName).e(Language.flag)
            it.tvItemLanguage.setBackgroundColor(
                if (Language.isSelectLang(langKey)) context.resources
                    .getColor(R.color.select_language_ok,null) else context.resources
                    .getColor(R.color.select_language_not,null)
            )
        }
    }
}