package com.thoughtworks.mylibrary.ui.innercontainerfragment

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavGraph
import androidx.navigation.fragment.NavHostFragment
import com.thoughtworks.mylibrary.`interface`.NestedFragment
import com.thoughtworks.mylibrary.R

internal class InnerContainerFragment : Fragment(), NestedFragment {

    private lateinit var viewModel: InnerContainerFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        println("mylibrary:InnerContainerFragment: onCreateView()")
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
        println("mylibrary:InnerContainerFragment: onViewCreated()")
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onAttach(context: Context) {
        println("mylibrary:InnerContainerFragment: onAttach()")
        super.onAttach(context)
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        println("mylibrary:InnerContainerFragment: onViewStateRestored()")
        super.onViewStateRestored(savedInstanceState)
    }

    override fun onStart() {
        println("mylibrary:InnerContainerFragment: onStart()")
        super.onStart()
    }

    override fun onResume() {
        println("mylibrary:InnerContainerFragment: onResume()")
        super.onResume()
    }

    override fun onStop() {
        println("mylibrary:InnerContainerFragment: onStop()")
        super.onStop()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        println("mylibrary:InnerContainerFragment: onSaveInstanceState()")
        super.onSaveInstanceState(outState)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        println("mylibrary:InnerContainerFragment: onCreate()")
        super.onCreate(savedInstanceState)
    }

    override fun onDestroyView() {
        println("mylibrary:InnerContainerFragment: onDestroyView()")
        super.onDestroyView()
    }

    override fun onDestroy() {
        println("mylibrary:InnerContainerFragment: onDestroy()")
        super.onDestroy()
    }

    override fun onDetach() {
        println("mylibrary:InnerContainerFragment: onDetach()")
        super.onDetach()
    }

}