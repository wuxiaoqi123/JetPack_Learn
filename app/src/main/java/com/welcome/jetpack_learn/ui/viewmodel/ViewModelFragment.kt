package com.welcome.jetpack_learn.ui.viewmodel

import android.os.Bundle
import android.os.SystemClock
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.welcome.jetpack_learn.R
import kotlinx.android.synthetic.main.fragment_view_model.*

class ViewModelFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_view_model, container, false)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val vm = ViewModelProviders.of(this).get(DemoViewModel::class.java)
        if (vm.time == null) {
            vm.time = SystemClock.elapsedRealtime()
        }
        chronometer.base = vm.time!!
        chronometer.start()

        btn_fragment_share.setOnClickListener {
            findNavController().navigate(R.id.viewModelShareActivity)
        }
    }
}