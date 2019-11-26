package com.welcome.jetpack_learn.utils

import android.content.Context
import com.welcome.jetpack_learn.data.respository.HomeRepository

object Injection{

    fun provideHomeRepository(context:Context) =
        HomeRepository.getInstance(
            HomeDB
        )
}