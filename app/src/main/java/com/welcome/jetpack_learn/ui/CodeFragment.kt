package com.welcome.jetpack_learn.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.welcome.jetpack_learn.databinding.FragmentCodeBinding

class CodeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FragmentCodeBinding.inflate(inflater, container, false).root
    }
}