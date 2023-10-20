package com.example.pagination.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.pagination.databinding.QuotesItemBinding
import com.example.pagination.model.Result

class QuotesPagingAdapter: PagingDataAdapter<Result, QuotesPagingAdapter.QuotesViewHolder>(DiffUtil()) {

    inner class QuotesViewHolder(private val binding: QuotesItemBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Result) {
            binding.quote.text = item.content
        }
    }

    override fun onBindViewHolder(holder: QuotesViewHolder, position: Int) {
        val item = getItem(position)
        if (item != null) {
            holder.bind(item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuotesViewHolder {
        return QuotesViewHolder(QuotesItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    class DiffUtil: androidx.recyclerview.widget.DiffUtil.ItemCallback<Result>() {
        override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
            return oldItem._id == newItem._id
        }

        override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
            return oldItem == newItem
        }

    }

}