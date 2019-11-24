package com.welcome.jetpack_learn

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.welcome.jetpack_learn.utils.StatusBarUtil

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        StatusBarUtil.setLightMode(this)
        setContentView(R.layout.activity_main)
    }
}
