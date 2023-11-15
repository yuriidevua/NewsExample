package com.arch.presentation.fragment.group.adapter.news

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.arch.portdomain.model.NewsGroupModel
import com.arch.presentation.R
import com.arch.presentation.fragment.group.INewsGroup

class NewsGroupAdapter (val presenter: INewsGroup.Presenter)
    : RecyclerView.Adapter<NewsGroupViewHolder>() {
    private var mList  = mutableListOf<NewsGroupModel>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsGroupViewHolder {
        return NewsGroupViewHolder(parent.context, LayoutInflater.from(parent.context)
            .inflate(R.layout.item_group, parent, false), presenter)
    }

    override fun getItemCount(): Int = mList.size

    override fun onBindViewHolder(holder: NewsGroupViewHolder, position: Int) {
        holder.bind(mList[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateAdapter(list : List<NewsGroupModel>){
        mList.clear()
        mList.addAll(list)
        notifyDataSetChanged()
    }
}