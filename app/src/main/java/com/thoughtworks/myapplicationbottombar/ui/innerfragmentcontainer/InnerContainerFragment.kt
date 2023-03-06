package com.thoughtworks.myapplicationbottombar.ui.innerfragmentcontainer

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

    companion object {
        fun newInstance() = InnerContainerFragment()
    }

    private lateinit var viewModel: InnerFragmentContainerViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        println("InnerContainerFragment: onCreateView()")
        return inflater.inflate(R.layout.fragment_inner_container_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(InnerFragmentContainerViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onBackPressed(): Boolean {
        val navHostFragment = childFragmentManager.findFragmentById(R.id.inner_fragment) as NavHostFragment

        val navController = navHostFragment.navController
        return if (this.isVisible && navController.backQueue.count { it.destination !is NavGraph } > 1) {
            navController.popBackStack()
        } else {
            false
        }
    }

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