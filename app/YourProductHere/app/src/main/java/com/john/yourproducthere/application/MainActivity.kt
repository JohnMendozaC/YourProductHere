package com.john.yourproducthere.application

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.john.yourproducthere.R
import com.john.yourproducthere.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setEventOnBackToHomeAsUpIndicator()
    }

    private fun setEventOnBackToHomeAsUpIndicator() {
        binding.toolbar.setNavigationOnClickListener {
            onBackPressed()
        }
    }
}
