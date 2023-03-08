package com.thoughtworks.mylibrary.ui.news

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.thoughtworks.mylibrary.R
import com.thoughtworks.mylibrary.databinding.FragmentNewsBinding
import com.thoughtworks.mylibrary.ui.newsdetailfragment.NewsDetailFragment

internal class NewsFragment : Fragment() {

    private var _binding: FragmentNewsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        println("NewsFragment: onCreateView()")
        _binding = FragmentNewsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        println("NewsFragment: onViewCreated()")
        super.onViewCreated(view, savedInstanceState)
        addBtnEvent()
    }

    private fun addBtnEvent() {
        binding.btnNewsDetail.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.notifications_child_fragment, NewsDetailFragment())
                .addToBackStack("Notifications")
                .setReorderingAllowed(true)
                .commit()
        }
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        println("NewsFragment: onViewStateRestored()")
        super.onViewStateRestored(savedInstanceState)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        println("NewsFragment: onSaveInstanceState()")
        super.onSaveInstanceState(outState)
    }

    override fun onAttach(context: Context) {
        println("NewsFragment: onAttach()")
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        println("NewsFragment: onCreate()")
        super.onCreate(savedInstanceState)
    }

    override fun onStart() {
        println("NewsFragment: onStart()")
        super.onStart()
    }

    override fun onResume() {
        println("NewsFragment: onResume()")
        super.onResume()
    }

    override fun onPause() {
        println("NewsFragment: onPause()")
        super.onPause()
    }

    override fun onStop() {
        println("NewsFragment: onStop()")
        super.onStop()
    }

    override fun onDestroy() {
        println("NewsFragment: onDestroy()")
        super.onDestroy()
    }

    override fun onDetach() {
        println("NewsFragment: onDetach()")
        super.onDetach()
    }

    override fun onDestroyView() {
        println("NewsFragment: onDestroyView()")
        super.onDestroyView()
    }
}