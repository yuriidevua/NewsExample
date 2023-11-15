package com.arch.presentation.fragment.group.adapter.lang

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.arch.presentation.R
import com.arch.presentation.fragment.group.INewsGroup
import com.arch.presentation.util.Language
import java.util.TreeMap

class NewsLanguageAdapter(val presenter: INewsGroup.Presenter)
    : RecyclerView.Adapter<NewsLangViewHolder>() {
    private var mList  = Language.listLanguage

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsLangViewHolder {
        return NewsLangViewHolder(parent.context, LayoutInflater.from(parent.context)
                .inflate(R.layout.item_lang, parent, false), presenter)
    }

    override fun getItemCount(): Int = mList.size

    override fun onBindViewHolder(holder: NewsLangViewHolder, position: Int) {
        holder.bind(mList.keys.toList()[position],mList.values.toList()[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateAdapter(){
        notifyDataSetChanged()
    }
}