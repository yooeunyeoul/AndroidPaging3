package com.dongeul.pagingsample.data

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.dongeul.pagingsample.databinding.ItemSampleBinding
import com.dongeul.pagingsample.databinding.ItemSampleHeaderBinding
import java.lang.Exception

class PagingAdapter : PagingDataAdapter<SampleModel, RecyclerView.ViewHolder>(diffcallback) {
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position)
        item?.let {

            when (holder) {
                is PagingHeaderViewHolder-> holder.bind(item as SampleModel.Header)
                is PagingViewHolder -> holder.bind(item as SampleModel.Data)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        val item = getItem(position)?: return -1

        return when (item) {
            is SampleModel.Header -> HEADER
            is SampleModel.Data -> DATA
            is SampleModel.Separator -> SEPARATOR
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            HEADER-> PagingHeaderViewHolder(ItemSampleHeaderBinding.inflate(layoutInflater,parent,false))
            DATA -> PagingViewHolder(ItemSampleBinding.inflate(layoutInflater,parent,false))
            else -> throw Exception()
        }
    }

    companion object {
        private const val HEADER = 0
        private const val DATA = 1
        private const val SEPARATOR = 2


        private val diffcallback = object : DiffUtil.ItemCallback<SampleModel>() {
            override fun areItemsTheSame(oldItem: SampleModel, newItem: SampleModel): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: SampleModel, newItem: SampleModel): Boolean {
                return oldItem == newItem
            }

        }
    }

}

class PagingHeaderViewHolder(
    private val binding: ItemSampleHeaderBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(data: SampleModel.Header) {
        binding.headerTitle.text = data.title
    }
}

class PagingViewHolder(
    private val binding: ItemSampleBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(data: SampleModel.Data) {
        binding.textView.text = data.value
    }
}