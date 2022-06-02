package com.dongeul.pagingsample.viewmodel

import com.dongeul.pagingsample.model.Comment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.*
import com.dongeul.mysamplelibrary.ToastID
import com.dongeul.pagingsample.base.BaseViewModel
import com.dongeul.pagingsample.model.SampleModel
import com.dongeul.pagingsample.repository.PagingRepository
import com.dongeul.pagingsample.ui.CommentAdapter
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PagingViewModel @Inject constructor(private val repository: PagingRepository) : BaseViewModel() {
    val pagingData = repository.getPagingData().cachedIn(viewModelScope).asLiveData()//cachedIn() 연산자는 데이터 스트림을 공유 가능하게 만들고, 제공된 CoroutineScope를 사용하여 로드 된 데이터를 캐시한다.
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