package com.dongeul.pagingsample.data

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.dongeul.pagingsample.databinding.ItemSampleBinding

class PagingAdapter : PagingDataAdapter<String, RecyclerView.ViewHolder>(diffcallback) {
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position)
        item?.let {
            if (holder is PagingViewHolder) {
                holder.bind(it)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return PagingViewHolder(ItemSampleBinding.inflate(layoutInflater,parent,false))
    }

    companion object {
        private val diffcallback = object : DiffUtil.ItemCallback<String>(){
            override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
                return oldItem == newItem
            }

        }
    }

}

class PagingViewHolder(
    private val binding:ItemSampleBinding
):RecyclerView.ViewHolder(binding.root) {
    fun bind(data: String) {
        binding.textView.text  = data
    }
}