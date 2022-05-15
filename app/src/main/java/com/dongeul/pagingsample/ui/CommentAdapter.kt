package com.dongeul.pagingsample.ui

import com.dongeul.pagingsample.model.Comment
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dongeul.pagingsample.databinding.ItemCommentBinding

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

