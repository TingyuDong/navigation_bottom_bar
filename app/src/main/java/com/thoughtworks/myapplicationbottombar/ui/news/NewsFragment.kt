package com.thoughtworks.myapplicationbottombar.ui.news

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.thoughtworks.myapplicationbottombar.R
import com.thoughtworks.myapplicationbottombar.ui.newsdetailfragment.NewsDetailFragment

class NewsFragment : Fragment() {

    private lateinit var viewModel: NewsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        println("NewsFragment: onCreateView()")
        return inflater.inflate(R.layout.fragment_news, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        println("NewsFragment: onViewCreated()")
        super.onViewCreated(view, savedInstanceState)
        addBtnEvent(view)
    }

    private fun addBtnEvent(view: View) {
        view.findViewById<Button>(R.id.btn_news_detail).setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.notifications_child_fragment, NewsDetailFragment())
                .addToBackStack("Notifications")
                .setReorderingAllowed(true)
                .commit()
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        println("NewsFragment: onActivityCreated()")
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(NewsViewModel::class.java)
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