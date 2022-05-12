package com.dongeul.pagingsample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import androidx.paging.filter
import androidx.paging.map
import com.dongeul.pagingsample.data.FeedType
import com.dongeul.pagingsample.data.SampleModel
import com.dongeul.pagingsample.databinding.FragmentFeedDetailBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class FeedDetailFragment : Fragment() {
    private var _binding: FragmentFeedDetailBinding? = null
    private val binding get() = _binding!!
    private val viewModel: PagingViewModel by activityViewModels()
//    private val args by navArgs<FeedDetailFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFeedDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
//            val data =args.data
//            binding.entity = data


        }

        lifecycleScope.launch {
            viewModel.pagingData.collectLatest {

            }
        }
    }
}