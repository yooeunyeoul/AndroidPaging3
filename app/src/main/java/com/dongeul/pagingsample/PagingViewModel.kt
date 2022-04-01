package com.dongeul.pagingsample

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.*
import com.dongeul.pagingsample.data.PagingSample
import com.dongeul.pagingsample.data.SampleModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class PagingViewModel @Inject constructor(private val repository: PagingRepository) : ViewModel() {
    val pagingData = repository.getPagingData().map { pagingData ->
        pagingData.map<String, SampleModel> { SampleModel.Data(it) }
            .insertHeaderItem(item = SampleModel.Header("Header"))
            .insertFooterItem(item = SampleModel.Header("Footer"))

    }.cachedIn(viewModelScope)
}