package com.dongeul.pagingsample

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.*
import com.dongeul.pagingsample.data.Comment
import com.dongeul.pagingsample.data.CommentAdapter
import com.dongeul.pagingsample.data.SampleModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class PagingViewModel @Inject constructor(private val repository: PagingRepository) : ViewModel() {
    val pagingData = repository.getPagingData().cachedIn(viewModelScope)
    val feedEntityLiveData = MutableLiveData<SampleModel.Data>()
    val commentAdapter = CommentAdapter()


    fun updateComment(comment: Comment? = null) {
        val entity = feedEntityLiveData.value
        val commentList = entity?.commentList?.toMutableList().apply {
            comment?.let { this?.add(it) }
        }
        entity?.commentList = commentList?.toList() ?: listOf()
        feedEntityLiveData.postValue(entity)
        commentList?.let { commentAdapter.updateComment(it) }
    }

    fun updateLike() {
        val entity = feedEntityLiveData.value
        entity?.let {
            it.run {
                if (isLike) {
                    isLike = false
                    likeCount -= 1
                } else {
                    isLike = true
                    likeCount += 1
                }
            }
        }
        feedEntityLiveData.postValue(entity)
    }
}