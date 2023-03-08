package com.thoughtworks.mylibrary.ui.newscontainer

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.thoughtworks.myapplicationbottombar.`interface`.NestedFragment
import com.thoughtworks.myapplicationbottombar.ui.newscontainer.NewsContainerViewModel
import com.thoughtworks.mylibrary.databinding.FragmentNewsContainerBinding

class NewsContainerFragment : Fragment(), NestedFragment {

    private var _binding: FragmentNewsContainerBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        println("NewsContainerFragment: onCreateView()")
        ViewModelProvider(this)[NewsContainerViewModel::class.java]

        _binding = FragmentNewsContainerBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onDestroyView() {
        println("NewsContainerFragment: onDestroyView()")
        super.onDestroyView()
        _binding = null
    }

    override fun onBackPressed(): Boolean {
        return if (childFragmentManager.backStackEntryCount > 0) {
            childFragmentManager.popBackStack()
            true
        } else false
    }

    override fun onAttach(context: Context) {
        println("NewsContainerFragment: onAttach()")
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        println("NewsContainerFragment: onCreate()")
        super.onCreate(savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        println("NewsContainerFragment: onActivityCreated()")
        super.onActivityCreated(savedInstanceState)
    }

    override fun onStart() {
        println("NewsContainerFragment: onStart()")
        super.onStart()
    }

    override fun onResume() {
        println("NewsContainerFragment: onResume()")
        super.onResume()
    }

    override fun onPause() {
        println("NewsContainerFragment: onPause()")
        super.onPause()
    }

    override fun onStop() {
        println("NewsContainerFragment: onStop()")
        super.onStop()
    }

    override fun onDestroy() {
        println("NewsContainerFragment: onDestroy()")
        super.onDestroy()
    }

    override fun onDetach() {
        println("NewsContainerFragment: onDetach()")
        super.onDetach()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        println("NewsContainerFragment: onViewCreated()")
        super.onViewCreated(view, savedInstanceState)
    }
}