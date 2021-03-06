package com.welcome.jetpack_learn.ui

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.welcome.jetpack_learn.R
import com.welcome.jetpack_learn.ui.livedata.LiveDataFragment
import com.welcome.jetpack_learn.ui.viewmodel.ViewModelFragment
import kotlinx.android.synthetic.main.fragment_more_sample.*
import kotlinx.android.synthetic.main.layout_loading.*
import widget.TabLayoutMediator

class MoreSampleFragment : Fragment() {

    private val mTitles = arrayOf("LiveData", "ViewModel", "Room", "WorkManager", "Camera2")
    private val mFgs by lazy {
        arrayOf(
            LiveDataFragment(),
            ViewModelFragment(),
            CodeFragment(),
            CodeFragment(),
            CodeFragment()
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_more_sample, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Handler().postDelayed({
            setUI()
            loading.visibility = View.GONE
        }, 500)
    }

    private fun setUI() {
        vp.adapter = object : FragmentStateAdapter(this) {
            override fun getItemCount(): Int = mFgs.size
            override fun createFragment(position: Int) = mFgs[position]
        }
        vp.offscreenPageLimit = mTitles.size
        TabLayoutMediator(tab, vp, TabLayoutMediator.OnConfigureTabCallback { tab, position ->
            tab.text = mTitles[position]
        }).attach()
    }
}