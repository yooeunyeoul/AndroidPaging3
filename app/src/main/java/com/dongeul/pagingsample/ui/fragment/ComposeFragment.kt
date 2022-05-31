package com.dongeul.pagingsample.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.dongeul.pagingsample.databinding.FragmentComposeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ComposeFragment : Fragment() {
    private lateinit var _binding: FragmentComposeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentComposeBinding.inflate(inflater,container,false)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}