package com.felina.Fiantmdbmovie.core.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.felina.Fiantmdbmovie.core.R
import com.felina.Fiantmdbmovie.core.databinding.ItemListReviewBinding
import com.felina.Fiantmdbmovie.core.domain.model.Review


class ReviewAdapter : RecyclerView.Adapter<ReviewAdapter.ListViewHolder>() {

    private var listData = ArrayList<Review>()

    fun setData(newListData: List<Review>?) {
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_list_review, parent, false))

    override fun getItemCount() = listData.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemListReviewBinding.bind(itemView)
        fun bind(data: Review) {
            with(binding) {
                tvItemUsername.text = data.author
                tvItemDate.text = data.createdAt
                tvItemContent.text = data.content
            }
        }
    }
}