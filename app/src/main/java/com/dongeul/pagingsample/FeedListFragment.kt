package com.dongeul.pagingsample

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.SimpleItemAnimator
import com.dongeul.pagingsample.data.FeedType
import com.dongeul.pagingsample.data.PagingAdapter
import com.dongeul.pagingsample.data.SampleModel
import com.dongeul.pagingsample.databinding.FragmentFeedListBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class FeedListFragment : Fragment() {

    private var _binding: FragmentFeedListBinding? = null
    private val binding get() = _binding!!
    private val viewModel: PagingViewModel by activityViewModels()
    private val pagingAdapter: PagingAdapter by lazy {
        PagingAdapter().apply {
            listener = {
                when (it.type) {
                    FeedType.AD->{
                        Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com")).run {
                            startActivity(this)
                        }
                    }
                    FeedType.DATA->{
                        val data = it as SampleModel.Data
                        FeedListFragmentDirections.actionHomeFragmentToDetailFragment(data).run {
                            findNavController().navigate(this)
                        }
                    }
                }
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFeedListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            recyclerView.run {
                adapter = pagingAdapter
                (itemAnimator as SimpleItemAnimator).supportsChangeAnimations = false
            }
        }
        lifecycleScope.launch {
            viewModel.pagingData.collectLatest {
                pagingAdapter.submitData(it)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}