package com.welcome.jetpack_learn.data.respository.gank

import com.welcome.jetpack_learn.data.Listing
import com.welcome.jetpack_learn.data.bean.Gank

class GankRespository {

    companion object {

        private const val PAGE_SIZE = 20

        @Volatile
        private var instance: GankRespository? = null

        fun getInstance() =
            instance ?: synchronized(this) {
                instance ?: GankRespository().also { instance = it }
            }
    }

    fun getGank(): Listing<Gank>? {
        return null
    }
}