package com.arch.presentation.fragment.favorites.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.arch.portdomain.model.NewsModel
import com.arch.presentation.R
import com.arch.presentation.fragment.favorites.IFavoritesNews

class FavoritesAdapter constructor(private val presenter: IFavoritesNews.Presenter)
    : RecyclerView.Adapter<FavoritesViewHolder>(){
    private var mList  = mutableListOf<NewsModel>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoritesViewHolder {
        return FavoritesViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.item_favorites, parent, false), presenter)
    }

    override fun getItemCount(): Int = mList.size

    override fun onBindViewHolder(holder: FavoritesViewHolder, position: Int) {
        if (mList.size != 0)holder.bind(mList[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateListAdapter(list : List<NewsModel>){
        mList.clear()
        mList.addAll(list)
        notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun deleteItem(item : NewsModel){
        val position = mList.indexOf(item)
        mList.remove(item)
        if (mList.size > 1) notifyItemChanged(position,item)
        else notifyDataSetChanged()
    }
}