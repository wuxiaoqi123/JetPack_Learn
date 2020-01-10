package com.welcome.jetpack_learn.ui.paging

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.welcome.jetpack_learn.R
import com.welcome.jetpack_learn.data.NetworkState
import com.welcome.jetpack_learn.databinding.ActivityPagingWithNetWorkBinding
import com.welcome.jetpack_learn.ext.obtainViewModel
import com.welcome.jetpack_learn.ext.setLightMode
import com.welcome.jetpack_learn.ext.setupToolBar
import com.welcome.jetpack_learn.ui.adapter.PagingWithNetWorkAdapter
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

        val adapter = PagingWithNetWorkAdapter()
        mDataBinding.rvPagingWithNetwork.adapter = adapter
        mDataBinding.vm?.gankList?.observe(this, Observer {
            adapter.submitList(it)
        })
        mDataBinding.vm?.refreshState?.observe(this, Observer {
            mDataBinding.rvPagingWithNetwork.post {
                mDataBinding.swipeRefresh.isRefreshing = it == NetworkState.LOADING
            }
        })

        mDataBinding.vm?.netWorkState?.observe(this, Observer {
            adapter.setNetworkState(it)
        })
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> finish()
        }
        return super.onOptionsItemSelected(item)
    }
}