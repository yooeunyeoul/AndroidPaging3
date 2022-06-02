package com.dongeul.pagingsample.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.dongeul.pagingsample.data.SamplePagingSource
import com.dongeul.pagingsample.model.SampleModel
import com.dongeul.pagingsample.network.SampleBackendService
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PagingRepository @Inject constructor(
    private val service: SampleBackendService
) {
    fun getPagingData() : Flow<PagingData<SampleModel>> {
        return Pager(PagingConfig(pageSize = 10)){
            SamplePagingSource(service)
        }.flow
    }

}