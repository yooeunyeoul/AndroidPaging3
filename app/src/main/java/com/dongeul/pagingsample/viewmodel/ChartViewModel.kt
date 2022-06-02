package com.dongeul.pagingsample.viewmodel

import androidx.lifecycle.viewModelScope
import com.dongeul.pagingsample.base.BaseViewModel
import com.dongeul.pagingsample.repository.ChartRepository
import com.github.mikephil.charting.data.LineData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class ChartViewModel @Inject constructor(val repository: ChartRepository) : BaseViewModel() {

    val chartData: StateFlow<LineData> =
        repository.getChartData(20)
            .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), LineData())


}