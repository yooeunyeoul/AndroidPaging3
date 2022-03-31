package com.dongeul.pagingsample

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.dongeul.pagingsample.data.PagingSample
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class PagingViewModel @Inject constructor(private val repository: PagingRepository) : ViewModel() {
    val pagingData = repository.getPagingData().cachedIn(viewModelScope)
}