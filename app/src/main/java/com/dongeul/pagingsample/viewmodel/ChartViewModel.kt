package com.dongeul.pagingsample.viewmodel

import androidx.lifecycle.ViewModel
import com.dongeul.pagingsample.repository.ChartRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ChartViewModel @Inject constructor(val repository : ChartRepository) : ViewModel() {


}