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
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.nobarecoffeshop.Adapter.CategoryAdapter


class MainActivity : AppCompatActivity() {
    private  lateinit var  binding: ActivityMainBinding
    private val viewModel= MainViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initBanner()
        initCategory()
    }

    private fun initCategory() {
        binding.progressBarCategory.visibility= View.VISIBLE
        viewModel.loadCategory().observeForever {
            binding.categoryView
                .layoutManager= LinearLayoutManager(
                this@MainActivity,
                LinearLayoutManager.HORIZONTAL,
                false
            )
            binding.categoryView.adapter= CategoryAdapter(it)
            binding.progressBarCategory.visibility= View.GONE
        }
        viewModel.loadCategory()
    }

    private fun initBanner(){
        binding.progressBarBanner.visibility = android.view.View.VISIBLE
        viewModel.loadBanner().observeForever {
            Glide.with(this@MainActivity)
                .load(it[0].url)
                .into(binding.banner)
            binding.progressBarBanner.visibility= android.view.View.GONE
        }
        viewModel.loadBanner()
    }
}