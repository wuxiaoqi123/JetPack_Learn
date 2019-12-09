package com.welcome.jetpack_learn.ui.navigation.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.setupWithNavController
import com.welcome.jetpack_learn.R
import com.welcome.jetpack_learn.utils.StatusBarUtil
import kotlinx.android.synthetic.main.activity_bottom_nav_sample.*

class BottomNavSampleActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_nav_sample)
        initView()
    }

    private fun initView() {
        StatusBarUtil.setLightMode(this)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(true)
        toolbar.setTitleTextColor(resources.getColor(R.color.black))
        navController = Navigation.findNavController(this, R.id.fragment_home_sample)
        toolbar.setNavigationOnClickListener {
            navController.navigateUp()
        }
        initBottomNavigation()
    }

    private fun initBottomNavigation() {
        bottom_navigation_view?.setupWithNavController(navController)
        navController.addOnDestinationChangedListener { _, destination, _ ->
            toolbar.title = destination.label
        }
    }
}