package com.welcome.jetpack_learn.data.respository

import androidx.paging.Config
import androidx.paging.toLiveData
import com.welcome.jetpack_learn.data.bean.User
import com.welcome.jetpack_learn.data.db.UserDao
import com.welcome.jetpack_learn.data.ioThread

class PagingRespository private constructor(private val userDao: UserDao) {

    fun getAllUsers() = userDao.queryUsersByName().toLiveData(
        Config(
            pageSize = 20,
            enablePlaceholders = true,
            maxSize = 200
        )
    )

    fun insert(text: CharSequence) = ioThread {
        userDao.insert(User(id = 0, name = text.toString()))
    }

    fun remove(cheese: User) = ioThread {
        userDao.delete(cheese)
    }

    companion object {
        @Volatile
        private var instance: PagingRespository? = null

        fun getInstance(userDao: UserDao) =
            instance ?: synchronized(this) {
                instance ?: PagingRespository(userDao).also {
                    instance = it
                }
            }
    }
}