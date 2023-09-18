package com.felina.Fiantmdbmovie.core.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.felina.Fiantmdbmovie.core.R
import com.felina.Fiantmdbmovie.core.databinding.ItemListMovieBinding
import com.felina.Fiantmdbmovie.core.domain.model.Video

class VideoAdapter : RecyclerView.Adapter<VideoAdapter.ListViewHolder>() {

    private var listData = ArrayList<Video>()
    var onItemClick: ((Video) -> Unit)? = null

    fun setData(newListData: List<Video>?) {
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_list_movie, parent, false))

    override fun getItemCount() = listData.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemListMovieBinding.bind(itemView)
        fun bind(data: Video) {
            with(binding) {
                Glide.with(itemView.context)
                    .load("https://img.youtube.com/vi/"+data.key+"/maxresdefault.jpg")
                    .into(ivItemImage)
                tvItemTitle.text = data.name
            }
        }

        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(listData[adapterPosition])
            }
        }
    }
}