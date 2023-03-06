package com.thoughtworks.myapplicationbottombar

import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavGraph
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.thoughtworks.myapplicationbottombar.`interface`.NestedFragment
import com.thoughtworks.myapplicationbottombar.databinding.ActivityMainBinding
import com.thoughtworks.myapplicationbottombar.ui.innerfragmentcontainer.InnerContainerFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        println("Activity: onCreate()")
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navHostFragment = getCurrentFragment() as NavHostFragment
        val navController = navHostFragment.navController
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_news
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)

        navView.setupWithNavController(navController)
        navView.setOnItemSelectedListener {
            val menuList = listOf(
                R.id.navigation_dashboard,
                R.id.navigation_news
            )
            (supportFragmentManager.findFragmentById(R.id.nav_host_fragment_activity_main) as? InnerContainerFragment)?.run {
                if (menuList.contains(it.itemId)) {
                    supportFragmentManager.beginTransaction()
                        .hide(this)
                        .commit()
                } else {
                    supportFragmentManager.beginTransaction()
                        .show(this)
                        .commit()
                }
            }

            NavigationUI.onNavDestinationSelected(
                it,
                navController
            )
            true
        }
    }

    override fun onStart() {
        println("Activity: onStart()")
        super.onStart()
    }

    private val onBackPressedCallback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            val menuList = listOf(
                R.id.navigation_dashboard,
                R.id.navigation_news
            )
            val navHostFragment = getCurrentFragment() as NavHostFragment
            val navController = navHostFragment.navController
            if (menuList.contains(navController.currentDestination?.id)) {
                binding.navView.selectedItemId = navController.graph.startDestinationId
            } else {
                navController.popBackStack()
            }
        }
    }

    override fun onBackPressed() {
        if (onBackPressedHandled()) return
        super.onBackPressed()
    }

    private fun onBackPressedHandled(): Boolean {
        return (getCurrentFragment() as? NestedFragment)?.onBackPressed()
            ?: ((getCurrentFragment() as? NavHostFragment)?.childFragmentManager
                ?.findFragmentById(R.id.nav_host_fragment_activity_main) as? NestedFragment)
                ?.onBackPressed() ?: false
    }

    private fun getCurrentFragment() =
        supportFragmentManager.findFragmentById(R.id.nav_host_fragment_activity_main)

    override fun onResume() {
        println("Activity: onResume()")
        super.onResume()
        val navHostFragment = getCurrentFragment() as NavHostFragment
        val navController = navHostFragment.navController
        onBackPressedDispatcher.addCallback(onBackPressedCallback)
        navController.addOnDestinationChangedListener { navigationController, _, _ ->
            onBackPressedCallback.isEnabled =
                navigationController.backQueue.count { it.destination !is NavGraph } > 1
        }
    }

    override fun onPause() {
        println("Activity: onPause()")
        super.onPause()
    }

    override fun onStop() {
        println("Activity: onStop()")
        super.onStop()
    }

    override fun onDestroy() {
        println("Activity: onDestroy()")
        super.onDestroy()
    }
}