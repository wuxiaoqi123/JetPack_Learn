package com.welcome.jetpack_learn.ui.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.welcome.jetpack_learn.R
import com.welcome.jetpack_learn.databinding.FragmentNavigationBinding

class NavigationFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentNavigationBinding.inflate(inflater, container, false)
        clickEvent(binding)
        return binding.root
    }

    private fun clickEvent(binding: FragmentNavigationBinding) {
        binding.btnNav.setOnClickListener {
            findNavController().navigate(NavigationFragmentDirections.actionNavigationFragmentToNavSampleActivity())
        }
        binding.btnBottom.setOnClickListener {
            findNavController().navigate(R.id.bottomNavSampleActivity)
        }
    }
}