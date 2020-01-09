package com.welcome.jetpack_learn.ui.paging

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.welcome.jetpack_learn.R
import com.welcome.jetpack_learn.databinding.ActivityPagingWithNetWorkBinding
import com.welcome.jetpack_learn.ext.obtainViewModel
import com.welcome.jetpack_learn.ext.setLightMode
import com.welcome.jetpack_learn.ext.setupToolBar
import kotlinx.android.synthetic.main.layout_toolbar.*

class PagingWithDaoNetWorkActivity : AppCompatActivity() {

    private lateinit var mViewModel: PagingWithNetWorkViewModel
    private lateinit var mDataBinding: ActivityPagingWithNetWorkBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_paging_with_net_work)
        setLightMode()
        setupToolBar(toolbar) {
            title = resources.getString(R.string.paging_with_network)
            setDisplayHomeAsUpEnabled(true)
        }
        mViewModel = obtainViewModel(PagingWithNetWorkViewModel::class.java)
        mDataBinding.vm = mViewModel
        mDataBinding.lifecycleOwner = this

    }
}