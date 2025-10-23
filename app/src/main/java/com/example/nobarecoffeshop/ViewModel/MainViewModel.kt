package com.example.nobarecoffeshop.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.nobarecoffeshop.Domain.BannerModel
import com.example.nobarecoffeshop.Domain.CategoryModel
import com.example.nobarecoffeshop.Domain.ItemsModel
import com.example.nobarecoffeshop.Repository.MainRepository

class MainViewModel: ViewModel() {
    private  val repository= MainRepository()

    fun loadBanner(): LiveData<MutableList<BannerModel>>{
        return repository.loadBanner()

    }

    fun loadCategory(): LiveData<MutableList<CategoryModel>>{
        return repository.loadCategory()
    }

    fun loadPopular(): LiveData<MutableList<ItemsModel>>{
        return repository.loadPopular()
    }


    fun loadItems(categoryId: String): LiveData<MutableList<ItemsModel>>{
        return repository.loadItemCategory(categoryId)
    }

}