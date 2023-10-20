package com.example.pagination.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.recyclerview.widget.RecyclerView
import com.example.pagination.databinding.LoadStateItemBinding

class LoadStateAdapter: androidx.paging.LoadStateAdapter<LoadStateAdapter.LoadStateAdapterViewHolder>() {

    inner class LoadStateAdapterViewHolder(private val binding: LoadStateItemBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(loadState: LoadState) {
            binding.progressBar.isVisible = loadState is LoadState.Loading
        }
    }

    override fun onBindViewHolder(holder: LoadStateAdapterViewHolder, loadState: LoadState) {
        holder.bind(loadState)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        loadState: LoadState
    ): LoadStateAdapterViewHolder {
        return LoadStateAdapterViewHolder(LoadStateItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }
}