package com.dongeul.pagingsample.ui

import com.dongeul.pagingsample.model.SampleModel
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.dongeul.pagingsample.databinding.ItemAdBinding
import com.dongeul.pagingsample.databinding.ItemFeedBinding
import java.lang.Exception

class PagingAdapter : PagingDataAdapter<SampleModel, RecyclerView.ViewHolder>(diffcallback) {


    lateinit var listener: (SampleModel) -> (Unit)
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position)
        item?.let {
            when (holder) {
                is PagingAdViewHolder -> holder.bind(item as SampleModel.Ad)
                is PagingViewHolder -> holder.bind(item as SampleModel.Data)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        val item = getItem(position) ?: return -1

        return when (item) {
            is SampleModel.Ad -> AD
            is SampleModel.Data -> DATA
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            AD -> PagingAdViewHolder(ItemAdBinding.inflate(layoutInflater, parent, false))
            DATA -> PagingViewHolder(ItemFeedBinding.inflate(layoutInflater, parent, false))
            else -> throw Exception()
        }
    }

    companion object {
        private const val AD = 0
        private const val DATA = 1


        private val diffcallback = object : DiffUtil.ItemCallback<SampleModel>() {
            override fun areItemsTheSame(oldItem: SampleModel, newItem: SampleModel): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: SampleModel, newItem: SampleModel): Boolean {
                return oldItem == newItem
            }

        }
    }

    inner class PagingAdViewHolder(
        private val binding: ItemAdBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: SampleModel.Ad) {
            binding.root.setOnClickListener {
                listener.invoke(data)
            }
        }
    }

    inner class PagingViewHolder(
        private val binding: ItemFeedBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: SampleModel.Data) {
            with(binding) {
                entity = data
                rootView.setOnClickListener {
                    listener.invoke(data)
                }
                ivHeart.setOnClickListener {
                    with(data) {
                        if (isLike) {
                            isLike = false
                            likeCount -= 1
                        } else {
                            isLike = true
                            likeCount += 1
                        }
                    }

                    notifyItemChanged(bindingAdapterPosition)
                }

                commentListView.adapter = CommentAdapter(data.commentList.toMutableList())
            }
        }
    }
}

