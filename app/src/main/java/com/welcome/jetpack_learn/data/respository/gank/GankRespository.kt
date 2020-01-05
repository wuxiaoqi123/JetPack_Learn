package com.welcome.jetpack_learn.data.respository.gank

import androidx.lifecycle.Transformations
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.welcome.jetpack_learn.data.Listing
import com.welcome.jetpack_learn.data.bean.Gank

class GankRespository {

    companion object {

        private const val PAGE_SIZE = 20

        @Volatile
        private var instance: GankRespository? = null

        fun getInstance() =
            instance ?: synchronized(this) {
                instance ?: GankRespository().also { instance = it }
            }
    }

    fun getGank(): Listing<Gank> {
        val sourceFactory = GankSourceFactory()
        val config = PagedList.Config.Builder()
            .setPageSize(PAGE_SIZE)
            .setInitialLoadSizeHint(PAGE_SIZE * 2)
            .setEnablePlaceholders(false)
            .build()
        val livePageList = LivePagedListBuilder<Int, Gank>(sourceFactory, config).build()
        val refreshState = Transformations.switchMap(sourceFactory.sourceLiveData) {
            it.initialLoad
        }
        return Listing(
            pagedList = livePageList,
            networkState = Transformations.switchMap(sourceFactory.sourceLiveData) { it.netWorkState },
            retry = { sourceFactory.sourceLiveData.value?.retryAllFailed() },
            refresh = { sourceFactory.sourceLiveData.value?.invalidate() },
            refreshState = refreshState
        )
    }
}