package com.thoughtworks.myapplicationbottombar.ui.mybooks

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.thoughtworks.myapplicationbottombar.R

class MyBooksFragment : Fragment() {

    private lateinit var viewModel: MyBooksViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_my_books, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MyBooksViewModel::class.java)
        // TODO: Use the ViewModel
    }

}