package com.thoughtworks.myapplicationbottombar

import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavGraph
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)

        navView.setupWithNavController(navController)
        navView.setOnItemSelectedListener {
            NavigationUI.onNavDestinationSelected(
                it,
                navController
            )
            true
        }
    }

    override fun onStart() {
        super.onStart()
        val navHostFragment = getCurrentFragment() as NavHostFragment
        val navController = navHostFragment.navController
        navController.addOnDestinationChangedListener { navc, destination, _ ->
            onBackPressedCallback.isEnabled =
                navc.backQueue.count { it.destination !is NavGraph } > 1
            onBackPressedDispatcher.addCallback(onBackPressedCallback)
        }

    }

    private val onBackPressedCallback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            val menuList = listOf(
                R.id.navigation_home,
                R.id.navigation_dashboard,
                R.id.navigation_notifications
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
        val current = getCurrentFragment()
        return (current as? NestedFragment)?.onBackPressed()
            ?: ((current as? NavHostFragment)?.childFragmentManager
                ?.findFragmentById(R.id.nav_host_fragment_activity_main) as? NestedFragment)
                ?.onBackPressed() ?: false
    }

    private fun getCurrentFragment() =
        supportFragmentManager.findFragmentById(R.id.nav_host_fragment_activity_main)
}