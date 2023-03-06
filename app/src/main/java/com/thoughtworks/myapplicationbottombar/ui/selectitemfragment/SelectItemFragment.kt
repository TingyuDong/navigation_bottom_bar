package com.thoughtworks.myapplicationbottombar.ui.selectitemfragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.thoughtworks.myapplicationbottombar.R

class SelectItemFragment : Fragment() {

    private lateinit var viewModel: SelectItemViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_select_item, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SelectItemViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addBtnEvent()
    }

    private fun addBtnEvent() {
        view?.findViewById<Button>(R.id.btn_news)?.setOnClickListener {
            findNavController().navigate(R.id.newsContainerFragment)
        }
    }

}