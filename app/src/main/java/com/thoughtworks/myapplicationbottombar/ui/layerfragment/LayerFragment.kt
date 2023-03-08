package com.thoughtworks.myapplicationbottombar.ui.layerfragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.thoughtworks.myapplicationbottombar.R

class LayerFragment : Fragment() {

    companion object {
        fun newInstance() = LayerFragment()
    }

    private lateinit var viewModel: LayerViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_layer, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(LayerViewModel::class.java)
        // TODO: Use the ViewModel
    }

}