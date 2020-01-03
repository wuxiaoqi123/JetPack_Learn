package com.welcome.jetpack_learn.ui.paging

import androidx.lifecycle.ViewModel
import com.welcome.jetpack_learn.data.bean.User
import com.welcome.jetpack_learn.data.respository.PagingRespository

class PagingWithDaoViewModel internal constructor(private val pagingRespository: PagingRespository) :
    ViewModel() {
    val allUsers = pagingRespository.getAllUsers()

    fun insert(text: CharSequence) {
        pagingRespository.insert(text)
    }

    fun remove(user: User) {
        pagingRespository.remove(user)
    }
}