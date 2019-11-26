package com.welcome.jetpack_learn

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.welcome.jetpack_learn.databinding.ActivityMainBinding
import com.welcome.jetpack_learn.utils.StatusBarUtil

class MainActivity : AppCompatActivity() {

    private lateinit var mDataBinding: ActivityMainBinding
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        StatusBarUtil.setLightMode(this)
        mDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        drawerLayout = mDataBinding.drawerLayout
        mDataBinding.toolbar.setTitleTextColor(resources.getColor(R.color.black))
        navController = Navigation.findNavController(this, R.id.fragment_home)
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.homeFragment,
                R.id.pagingDemoFragment,
                R.id.navigationFragment,
                R.id.lifecyclesFragment
            ), drawerLayout
        )
        setSupportActionBar(mDataBinding.toolbar)
        setupActionBarWithNavController(navController, appBarConfiguration)
        mDataBinding.navView.setupWithNavController(navController)
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_settings -> {
                requestPermission()
            }
            else -> super.onOptionsItemSelected(item)
        }
        return false
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    private fun requestPermission(){

    }
}
