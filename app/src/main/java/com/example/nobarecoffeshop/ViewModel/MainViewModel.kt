package com.example.nobarecoffeshop.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.nobarecoffeshop.Domain.BannerModel
import com.example.nobarecoffeshop.Repository.MainRepository

class MainViewModel: ViewModel() {
    private  val repository= MainRepository()

    fun loadBanner(): LiveData<MutableList<BannerModel>>{
        return repository.loadBanner()

    }
}