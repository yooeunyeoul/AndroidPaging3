package com.dongeul.pagingsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.dongeul.pagingsample.data.PagingAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel:PagingViewModel by viewModels()
    private val adapter : PagingAdapter by lazy {
        PagingAdapter()
    }
    private val recyclerView : RecyclerView by lazy {
        findViewById(R.id.recyclerView)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.adapter=adapter


        lifecycleScope.launch {
            viewModel.pagingData.collectLatest {
                adapter.submitData(it)
            }
        }


    }
}