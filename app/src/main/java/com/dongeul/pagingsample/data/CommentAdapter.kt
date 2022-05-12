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

class CommentAdapter constructor(private var commentList: MutableList<Comment> = mutableListOf()) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

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

    fun updateComment(commentList : MutableList<Comment>) {
        this.commentList.clear()
        this.commentList.addAll(commentList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return CommentViewHolder(ItemCommentBinding.inflate(layoutInflater, parent, false))
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

