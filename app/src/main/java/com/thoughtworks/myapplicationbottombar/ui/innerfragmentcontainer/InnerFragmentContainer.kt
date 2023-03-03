package com.thoughtworks.myapplicationbottombar.ui.innerfragmentcontainer

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import com.thoughtworks.myapplicationbottombar.R
import com.thoughtworks.myapplicationbottombar.`interface`.NestedFragment

class InnerFragmentContainer : Fragment(), NestedFragment {

    companion object {
        fun newInstance() = InnerFragmentContainer()
    }

    private lateinit var viewModel: InnerFragmentContainerViewModel
    private lateinit var navHostFragment: NavHostFragment

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        println("InnerFragmentContainer parent fragmentManager$parentFragmentManager")
        println("InnerFragmentContainer child fragmentManager$childFragmentManager")
        return inflater.inflate(R.layout.fragment_inner_fragment_container, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(InnerFragmentContainerViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onBackPressed(): Boolean {
        val navHostFragment = childFragmentManager.findFragmentById(R.id.inner_fragment) as NavHostFragment
        return if (navHostFragment.childFragmentManager.backStackEntryCount > 0) {
            navHostFragment.childFragmentManager.popBackStack()
            true
        } else false
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
    }

}