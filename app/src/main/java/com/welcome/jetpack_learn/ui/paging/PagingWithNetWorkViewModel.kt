package com.welcome.jetpack_learn.ui.paging

import androidx.lifecycle.ViewModel
import com.welcome.jetpack_learn.data.respository.gank.GankRespository

class PagingWithNetWorkViewModel(
    private val gankResponsitory: GankRespository
) : ViewModel() {

    private val mData = gankResponsitory.getGank()

    val gankList = mData.pagedList

    val netWorkState = mData.networkState

    val refreshState = mData.refreshState

    fun refresh() {
        mData.refresh.invoke()
    }

    fun retry() {
        mData.retry.invoke()
    }
}