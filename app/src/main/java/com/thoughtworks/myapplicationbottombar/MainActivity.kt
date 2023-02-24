package com.thoughtworks.myapplicationbottombar

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.thoughtworks.myapplicationbottombar.`interface`.NestedFragment
import com.thoughtworks.myapplicationbottombar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navController.backQueue.first().id
        navView.setupWithNavController(navController)
        navView.setOnItemSelectedListener {
            NavigationUI.onNavDestinationSelected(
                it,
                navController
            )
            true
        }
    }

    override fun onBackPressed() {
        val navHostFragment = getCurrentFragment() as NavHostFragment
        val current =
            navHostFragment.childFragmentManager.findFragmentById(R.id.nav_host_fragment_activity_main)
        val homeMenuItem = binding.navView.menu.findItem(R.id.navigation_home)

        if (!(current is NestedFragment && current.onBackPressed())) {
            if (navController.currentBackStackEntry?.id != navController.backQueue.first().id
                && navHostFragment.childFragmentManager.backStackEntryCount == 1
            ) {
                NavigationUI.onNavDestinationSelected(
                    homeMenuItem,
                    navController
                )
                homeMenuItem.isChecked = true
            } else {
                super.onBackPressed()
            }
        }
    }

    private fun getCurrentFragment() =
        supportFragmentManager.findFragmentById(R.id.nav_host_fragment_activity_main)
}