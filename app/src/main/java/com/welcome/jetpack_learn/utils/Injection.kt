package com.welcome.jetpack_learn.utils

import android.content.Context
import com.welcome.jetpack_learn.data.db.HomeDB
import com.welcome.jetpack_learn.data.db.UserDB
import com.welcome.jetpack_learn.data.net.Api
import com.welcome.jetpack_learn.data.net.HttpClient
import com.welcome.jetpack_learn.data.respository.HomeRepository
import com.welcome.jetpack_learn.data.respository.PagingRespository
import com.welcome.jetpack_learn.data.respository.gank.GankRespository

object Injection {

    fun provideHomeRepository(context: Context) =
        HomeRepository.getInstance(
            HomeDB.getInstance(context.applicationContext).homeDao()
        )

    fun providePagingRepository(context: Context) =
        PagingRespository.getInstance(UserDB.get(context.applicationContext).userDao())

    fun provideGankRespository() = GankRespository.getInstance()

    fun provideApi(): Api = HttpClient.instance
}