package com.dongeul.pagingsample.data

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.dongeul.pagingsample.FeedListFragment
import com.dongeul.pagingsample.FeedListFragmentDirections
import com.dongeul.pagingsample.FeedListFragment_GeneratedInjector
import com.dongeul.pagingsample.databinding.ItemAdBinding
import com.dongeul.pagingsample.databinding.ItemCommentBinding
import com.dongeul.pagingsample.databinding.ItemFeedBinding
import com.dongeul.pagingsample.databinding.ItemSampleHeaderBinding
import java.lang.Exception

class CommentAdapter constructor(val commentList : List<Comment>) : PagingDataAdapter<Comment, RecyclerView.ViewHolder>(diffcallback) {


    override fun getItemCount(): Int {
        return commentList.size
    }
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = commentList[position]
        item.let {
            if (holder is CommentViewHolder) {
                holder.bind(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return CommentViewHolder(ItemCommentBinding.inflate(layoutInflater, parent, false))
    }

    companion object {
        private val diffcallback = object : DiffUtil.ItemCallback<Comment>() {
            override fun areItemsTheSame(oldItem: Comment, newItem: Comment): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Comment, newItem: Comment): Boolean {
                return oldItem == newItem
            }
        }
    }

    inner class CommentViewHolder(
        private val binding: ItemCommentBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Comment) {
            binding.tvUser.text = data.commentUser
            binding.tvComment.text = data.comment
        }
    }
}

