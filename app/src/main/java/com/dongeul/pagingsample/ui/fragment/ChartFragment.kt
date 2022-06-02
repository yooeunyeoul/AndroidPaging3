package com.dongeul.pagingsample.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.dongeul.pagingsample.databinding.FragmentChartBinding
import com.dongeul.pagingsample.viewmodel.ChartViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class ChartFragment : Fragment() {
    private lateinit var _binding: FragmentChartBinding
    private val binding get() = _binding

    private val viewModel: ChartViewModel by viewModels()

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
            lifecycleScope.launchWhenStarted {
                viewModel.chartData.collectLatest {
                    binding.lineChartView.data = it
                    binding.lineChartView.invalidate()
                }
            }
        }
    }
}