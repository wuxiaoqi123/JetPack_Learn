package com.welcome.jetpack_learn.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.welcome.jetpack_learn.databinding.FragmentHomeBinding
import com.welcome.jetpack_learn.ui.adapter.HomeListAdapter

class HomeFragment : Fragment() {

    private var isLine: Boolean = false
    private lateinit var viewModel: HomeListViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentHomeBinding.inflate(inflater, container, false)
        context ?: return binding.root
        val adapter = HomeListAdapter()
        binding.rvHome.adapter = adapter
        subscribeUi(adapter, binding)
        return binding.root
    }

    private fun subscribeUi(adapter: HomeListAdapter, binding: FragmentHomeBinding) {

    }
}