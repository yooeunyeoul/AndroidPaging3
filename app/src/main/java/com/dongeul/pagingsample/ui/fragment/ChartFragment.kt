package com.dongeul.pagingsample.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import com.dongeul.pagingsample.databinding.FragmentChartBinding
import com.dongeul.pagingsample.viewmodel.ChartViewModel
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ChartFragment : Fragment() {
    private lateinit var _binding: FragmentChartBinding
    private val binding get() = _binding

    private val viewModel : ChartViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentChartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {

            val data = getData(20, 1000f)
            setupChart(data)
        }
    }

    private fun setupChart(data: LineData) {

        binding.lineChartView.data = data

    }

    fun getData(count: Int, range: Float): LineData {
        val values = ArrayList<Entry>()

        for (i in 0..count) {
            val floatVal: Float = ((Math.random() * range) + 3).toFloat()

//            values.add(Entry(i.toFloat(), i.toFloat()))
            values.add(Entry(i.toFloat(),floatVal))
        }

        val set1 = LineDataSet(values, "DataSet 1")

        return LineData(set1)
    }
}