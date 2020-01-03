package com.welcome.jetpack_learn.ui.paging

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.welcome.jetpack_learn.R
import com.welcome.jetpack_learn.ext.setLightMode
import com.welcome.jetpack_learn.ext.setupToolBar
import kotlinx.android.synthetic.main.activity_main.*

class PagingWithDaoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_paging_with_dao)
        setLightMode()
        setupToolBar(toolbar) {
            title = resources.getString(R.string.paging_with_dao)
            setDisplayHomeAsUpEnabled(true)
        }
    }

}