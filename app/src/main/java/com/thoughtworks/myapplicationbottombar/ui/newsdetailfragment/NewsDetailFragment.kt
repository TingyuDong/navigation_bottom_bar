package com.thoughtworks.myapplicationbottombar.ui.newsdetailfragment

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.thoughtworks.myapplicationbottombar.R

class NewsDetailFragment : Fragment() {

    private lateinit var viewModel: NewsDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        println("NewsDetailFragment: onCreateView()")
        return inflater.inflate(R.layout.fragment_news_detail, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        println("NewsDetailFragment: onActivityCreated()")
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(NewsDetailViewModel::class.java)
//        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner){
//            parentFragmentManager.popBackStack()
//        }
    }

    override fun onAttach(context: Context) {
        println("NewsDetailFragment: onAttach()")
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        println("NewsDetailFragment: onCreate()")
        super.onCreate(savedInstanceState)
    }

    override fun onStart() {
        println("NewsDetailFragment: onStart()")
        super.onStart()
    }

    override fun onResume() {
        println("NewsDetailFragment: onResume()")
        super.onResume()
    }

    override fun onPause() {
        println("NewsDetailFragment: onPause()")
        super.onPause()
    }

    override fun onStop() {
        println("NewsDetailFragment: onStop()")
        super.onStop()
    }

    override fun onDestroy() {
        println("NewsDetailFragment: onDestroy()")
        super.onDestroy()
    }

    override fun onDetach() {
        println("NewsDetailFragment: onDetach()")
        super.onDetach()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        println("NewsDetailFragment: onViewCreated()")
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        println("NewsDetailFragment: onDestroyView()")
        super.onDestroyView()
    }
}