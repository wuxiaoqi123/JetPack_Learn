package com.welcome.jetpack_learn.ui.livedata

import androidx.arch.core.util.Function
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.welcome.jetpack_learn.data.bean.User

class LiveDataViewModel : ViewModel() {

    val data = listOf(
        User(0, "Hankkin"),
        User(1, "Tony"),
        User(2, "Bob"),
        User(3, "Lucy")
    )

    val id = MutableLiveData<Int>()

    val bean: LiveData<User> = Transformations.map(id, Function {
        return@Function findUserById(id.value!!)
    })

    private fun findUserById(id: Int): User? {
        return data.find { it.id == id }
    }
}