package com.welcome.jetpack_learn.data.respository

import com.welcome.jetpack_learn.data.db.HomeDao

class HomeRepository private constructor(private val homeDao: HomeDao) {

    fun getPlants() = homeDao.getComponents()

    companion object {

        @Volatile
        private var instance: HomeRepository? = null

        fun getInstance(plantDao: HomeDao) =
            instance ?: synchronized(this) {
                instance ?: HomeRepository(plantDao).also { instance = it }
            }
    }
}