package com.example.nobarecoffeshop.Activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.nobarecoffeshop.R
import com.example.nobarecoffeshop.ViewModel.MainViewModel
import com.example.nobarecoffeshop.databinding.ActivityMainBinding
import android.view.View
import com.bumptech.glide.Glide


class MainActivity : AppCompatActivity() {
    private  lateinit var  binding: ActivityMainBinding
    private val viewModel= MainViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initBanner()
    }
    private fun initBanner(){
        binding.progressBarBanner.visibility = android.view.View.VISIBLE
        viewModel.loadBanner().observeForever {
            Glide.with(this@MainActivity)
                .load(it[0].url)
                .into(binding.banner)
            binding.progressBarBanner.visibility= android.view.View.GONE
        }
    }
}