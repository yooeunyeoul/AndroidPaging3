package com.dongeul.pagingsample

import com.dongeul.pagingsample.data.PagingSample
import javax.inject.Inject

class SampleBackendService @Inject constructor() {

    fun getPagingData(page:Int) : PagingSample {
        val result = mutableListOf<String>()

        val start = page * 10
        for (i in start until start + 10) {
            result.add("$i item")
        }
        return PagingSample(
            data = result,
            page= page+1
        )
    }
}