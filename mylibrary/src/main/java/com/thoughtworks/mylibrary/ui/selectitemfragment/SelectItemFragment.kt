package com.thoughtworks.mylibrary.ui.selectitemfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.thoughtworks.mylibrary.R
import com.thoughtworks.mylibrary.databinding.FragmentSelectItemBinding

class SelectItemFragment : Fragment() {

    private var _binding: FragmentSelectItemBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var viewModel: SelectItemViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSelectItemBinding.inflate(inflater, container, false)
        return binding.root
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
        binding.btnNews.setOnClickListener {
            findNavController().navigate(R.id.action_selectItemFragment_to_newsContainerFragment)
        }
    }

}