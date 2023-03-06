package com.thoughtworks.myapplicationbottombar.ui.innercontainerfragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavGraph
import androidx.navigation.fragment.NavHostFragment
import com.thoughtworks.myapplicationbottombar.R
import com.thoughtworks.myapplicationbottombar.`interface`.NestedFragment

class InnerContainerFragment : Fragment(), NestedFragment {

    private lateinit var viewModel: InnerContainerFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        println("InnerContainerFragment: onCreateView()")
        return inflater.inflate(R.layout.fragment_inner_container_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(InnerContainerFragmentViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onBackPressed(): Boolean {
        return if (onBackPressedHandled()) true
        else {
            handleOnBackPressed()
        }
    }

    private fun handleOnBackPressed(): Boolean {
        val navHostFragment = getCurrentFragment() as NavHostFragment
        val navController = navHostFragment.navController
        return if (navController.backQueue.count { it.destination !is NavGraph } > 1) {
            navController.popBackStack()
        } else {
            false
        }
    }

    private fun onBackPressedHandled(): Boolean {
        return (getCurrentFragment() as? NestedFragment)?.onBackPressed()
            ?: ((getCurrentFragment() as? NavHostFragment)?.childFragmentManager?.findFragmentById(R.id.inner_fragment) as? NestedFragment)?.onBackPressed()
            ?: false
    }

    private fun getCurrentFragment() = childFragmentManager.findFragmentById(R.id.inner_fragment)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        println("InnerContainerFragment: onViewCreated()")
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onStart() {
        println("InnerContainerFragment: onStart()")
        super.onStart()
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        println("InnerContainerFragment: onViewStateRestored()")
        super.onViewStateRestored(savedInstanceState)
    }

    override fun onResume() {
        println("InnerContainerFragment: onResume()")
        super.onResume()
    }

}