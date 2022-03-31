package com.dongeul.pagingsample

import androidx.paging.PagingSource
import androidx.paging.PagingState
import java.lang.Exception
import javax.inject.Inject

class SamplePagingSource @Inject constructor(
    private val service: SampleBackendService
) : PagingSource<Int, String>() {
    override fun getRefreshKey(state: PagingState<Int, String>): Int? {

        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)

        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, String> {
        return try {
            val next = params.key ?: 0
            val response = service.getPagingData(next)
            LoadResult.Page(
                data = response.data,
                prevKey = if (next == 0) null else next - 1,
                nextKey = next + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}