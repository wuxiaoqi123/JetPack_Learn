package com.welcome.jetpack_learn.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.welcome.jetpack_learn.data.bean.Component
import com.welcome.jetpack_learn.data.respository.HomeRepository

class HomeListViewModel internal constructor(homeRepository: HomeRepository) : ViewModel() {

    val listData: LiveData<List<Component>> = homeRepository.getPlants()
}