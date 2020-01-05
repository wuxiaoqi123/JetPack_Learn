package com.welcome.jetpack_learn.data.respository.gank

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.welcome.jetpack_learn.data.bean.Gank
import com.welcome.jetpack_learn.data.net.Api
import com.welcome.jetpack_learn.utils.Injection

class GankSourceFactory(private val api: Api = Injection.provideApi()) :
    DataSource.Factory<Int, Gank>() {

    val sourceLiveData = MutableLiveData<GankDataSource>()

    override fun create(): DataSource<Int, Gank> {
        val source = GankDataSource(api)
        sourceLiveData.postValue(source)
        return source
    }
}