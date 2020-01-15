package com.welcome.jetpack_learn.ui.livedata

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.welcome.jetpack_learn.R
import com.welcome.jetpack_learn.ext.obtainViewModel
import com.welcome.jetpack_learn.utils.FloatWindowUtils
import com.yhao.floatwindow.FloatWindow
import kotlinx.android.synthetic.main.fragment_live_data.*

class LiveDataFragment : Fragment() {

    private lateinit var liveData: MutableLiveData<String>
    private var mId = -1

    private val viewModel: LiveDataViewModel by lazy { obtainViewModel(LiveDataViewModel::class.java) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_live_data, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        liveData = MutableLiveData()
        btn_observer_data.setOnClickListener {
            if (FloatWindow.get() == null) {
                FloatWindowUtils.init(activity?.application!!)
            }
            FloatWindowUtils.show()
            val statusObserver = Observer<String> { lifeStatus ->
                FloatWindowUtils.addViewContent("LiveData-onChanged:$lifeStatus")
            }
            liveData.observeForever(statusObserver)
        }
        btn_observer_map.setOnClickListener {
            mId++
            viewModel.id.postValue(mId)
        }
        viewModel.bean.observe(this,
            Observer {
                tv_livedata_map.text = if (it == null) "未查找到User" else "为你查找到的User为：${it.name}"
            })
    }

    override fun onStart() {
        super.onStart()
        liveData.value = "onStart()"
    }

    override fun onPause() {
        super.onPause()
        liveData.value = "onPause()"
    }

    override fun onStop() {
        super.onStop()
        liveData.value = "onStop()"
    }

    override fun onDestroy() {
        super.onDestroy()
        liveData.value = "onDestroy()"
    }
}