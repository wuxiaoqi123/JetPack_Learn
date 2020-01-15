package com.welcome.jetpack_learn.ui.viewmodel

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.welcome.jetpack_learn.R
import com.welcome.jetpack_learn.ext.setLightMode
import com.welcome.jetpack_learn.ext.setupToolBar
import kotlinx.android.synthetic.main.activity_main.*

class ViewModelShareActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_model_share)
        setLightMode()
        setupToolBar(toolbar) {
            setDisplayHomeAsUpEnabled(true)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> finish()
        }
        return super.onOptionsItemSelected(item)
    }
}