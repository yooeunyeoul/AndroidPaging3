package com.dongeul.pagingsample.repository

import com.dongeul.pagingsample.network.SampleBackendService
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ChartRepository @Inject constructor(private val service: SampleBackendService) {

     fun getChartData(count: Int): Flow<LineData> = flow {
         delay(2000)
        val values = ArrayList<Entry>()
        val floatList = service.getChartData(count)
        floatList.forEachIndexed { index, fl ->
            values.add(Entry(index.toFloat(), fl))
        }
        val set1 = LineDataSet(values, "DataSet 1")
        emit(LineData(set1))
    }
}