package com.welcome.jetpack_learn.app

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.welcome.jetpack_learn.data.respository.HomeRepository
import com.welcome.jetpack_learn.ui.home.HomeListViewModel
import com.welcome.jetpack_learn.utils.Injection

class ViewModelFactory(
    private val homeRepository: HomeRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        with(modelClass) {
            when {
                isAssignableFrom(HomeListViewModel::class.java) -> {
                    HomeListViewModel(homeRepository)
                }
                else ->
                    throw IllegalArgumentException("Unknown ViewModel:${modelClass.name}")
            }
        } as T

    companion object {
        private var INSTANCE: ViewModelFactory? = null
        fun getInstance(application: Application) =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: ViewModelFactory(
                    Injection.provideHomeRepository(application)
                )
            }
    }
}