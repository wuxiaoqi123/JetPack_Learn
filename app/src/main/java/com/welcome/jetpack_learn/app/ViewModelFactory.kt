package com.welcome.jetpack_learn.app

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.welcome.jetpack_learn.data.respository.HomeRepository

class ViewModelFactory(
    private val homeRepository: HomeRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return super.create(modelClass)
    }

    companion object {
        private var INSTANCE: ViewModelFactory? = null
        fun getInstance(application:Application)=
            INSTANCE?:synchronized(this){
                INSTANCE?:ViewModelFactory(
                    InJe
                )
            }
    }
}