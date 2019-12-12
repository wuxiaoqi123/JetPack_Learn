package com.welcome.jetpack_learn.ui.lifecycles

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.welcome.jetpack_learn.R
import com.yhao.floatwindow.FloatWindow
import kotlinx.android.synthetic.main.fragment_lifecycles.*

class LifecyclesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_lifecycles, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setUI()
    }

    private fun setUI() {
        btn_add_obserber.setOnClickListener {
            if (FloatWindow.get() == null) {
            }
        }
        btn_location.setOnClickListener {

        }
    }
}