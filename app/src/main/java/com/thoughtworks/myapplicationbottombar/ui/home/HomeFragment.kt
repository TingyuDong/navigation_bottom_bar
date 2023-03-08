package com.thoughtworks.myapplicationbottombar.ui.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.thoughtworks.myapplicationbottombar.R
import com.thoughtworks.myapplicationbottombar.databinding.FragmentHomeBinding
import com.thoughtworks.mylibrary.NavigatorUtil

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        println("HomeFragment: onCreateView()")
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        println("HomeFragment: onViewCreated()")
        super.onViewCreated(view, savedInstanceState)
        addBtnEvent()
    }

    private fun addBtnEvent() {
        binding.btnMyNotes.setOnClickListener {
            activity?.supportFragmentManager?.findFragmentById(R.id.nav_host_fragment_activity_main)?.run {
                childFragmentManager
                    .beginTransaction()
                    .replace(R.id.nav_host_fragment_activity_main, NavigatorUtil().getInnerContainerFragment(), Bundle())
                    .addToBackStack("my notes")
                    .commit()
            }
        }
    }

    override fun onDestroyView() {
        println("HomeFragment: onDestroyView()")
        super.onDestroyView()
        _binding = null
    }

    override fun onAttach(context: Context) {
        println("HomeFragment: onAttach()")
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        println("HomeFragment: onCreate()")
        super.onCreate(savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        println("HomeFragment: onActivityCreated()")
        super.onActivityCreated(savedInstanceState)
    }

    override fun onStart() {
        println("HomeFragment: onStart()")
        super.onStart()
    }

    override fun onResume() {
        println("HomeFragment: onResume()")
        super.onResume()
    }

    override fun onPause() {
        println("HomeFragment: onPause()")
        super.onPause()
    }

    override fun onStop() {
        println("HomeFragment: onStop()")
        super.onStop()
    }

    override fun onDestroy() {
        println("HomeFragment: onDestroy()")
        super.onDestroy()
    }

    override fun onDetach() {
        println("HomeFragment: onDetach()")
        super.onDetach()
    }
}