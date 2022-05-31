package com.dongeul.pagingsample.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.dongeul.mysamplelibrary.ToastID
import com.dongeul.pagingsample.R
import com.dongeul.pagingsample.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.lifecycleOwner = this

        with(binding) {
            setContentView(root)
            val navHostFragment =
                supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
            navController = navHostFragment.findNavController()
            binding.bottomNavigationView.setupWithNavController(navController)
            setupActionBarWithNavController(navController)
        }
        ToastID().testToast(baseContext)

    }
}