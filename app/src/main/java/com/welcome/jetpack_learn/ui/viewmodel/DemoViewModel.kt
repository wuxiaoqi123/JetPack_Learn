package com.welcome.jetpack_learn.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DemoViewModel : ViewModel() {

    var time: Long? = null

    var seekbarValue = MutableLiveData<Int>()
}