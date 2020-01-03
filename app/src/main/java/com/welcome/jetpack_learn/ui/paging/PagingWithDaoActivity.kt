package com.welcome.jetpack_learn.ui.paging

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.welcome.jetpack_learn.R
import com.welcome.jetpack_learn.ext.obtainViewModel
import com.welcome.jetpack_learn.ext.setLightMode
import com.welcome.jetpack_learn.ext.setupToolBar
import com.welcome.jetpack_learn.ui.adapter.PagingDemoAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_paging_with_dao.*

class PagingWithDaoActivity : AppCompatActivity() {

    private lateinit var viewModel: PagingWithDaoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_paging_with_dao)
        setLightMode()
        setupToolBar(toolbar) {
            title = resources.getString(R.string.paging_with_dao)
            setDisplayHomeAsUpEnabled(true)
        }
        viewModel = obtainViewModel(PagingWithDaoViewModel::class.java)
        val adapter = PagingDemoAdapter()
        rv_paging.adapter = adapter
        viewModel.allUsers.observe(this, Observer(adapter::submitList))
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> finish()
        }
        return super.onOptionsItemSelected(item)
    }
}