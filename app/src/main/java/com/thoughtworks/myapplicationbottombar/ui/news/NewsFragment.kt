package com.thoughtworks.myapplicationbottombar.ui.news

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
        return inflater.inflate(R.layout.fragment_news, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
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
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(NewsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}