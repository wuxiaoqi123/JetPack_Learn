package com.welcome.jetpack_learn.ui.home

import android.content.res.AssetManager
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.hankkin.jetpack_learn.ui.adapter.HomeListAdapter
import com.welcome.jetpack_learn.R
import com.welcome.jetpack_learn.databinding.FragmentHomeBinding
import com.welcome.jetpack_learn.ext.obtainViewModel

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
        viewModel = obtainViewModel(HomeListViewModel::class.java)
        viewModel.listData.observe(viewLifecycleOwner, Observer { data ->
            if (data != null) adapter.submitList(data)
        })
        binding.fab.setOnClickListener {
            binding.rvHome.layoutManager =
                if (isLine) GridLayoutManager(context, 2) else LinearLayoutManager(context)
            binding.fab.setImageResource(if (isLine) R.mipmap.icon_lin else R.mipmap.icon_grid)
            isLine = !isLine
        }
    }
}