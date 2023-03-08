package com.thoughtworks.mylibrary.ui.mynotes

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.thoughtworks.myapplicationbottombar.ui.mynotes.MyNotesViewModel
import com.thoughtworks.mylibrary.R
import com.thoughtworks.mylibrary.databinding.FragmentMyNotesBinding

class MyNotesFragment : Fragment() {

    private var _binding: FragmentMyNotesBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var viewModel: MyNotesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        println("MyNotesFragment: onCreateView")
        _binding = FragmentMyNotesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        println("MyNotesFragment: onActivityCreated")
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MyNotesViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addBtnEvent()
    }

    private fun addBtnEvent() {
        binding.btnSelectItem.setOnClickListener {
        // view?.findViewById<Button>(R.id.btn_select_item)?.setOnClickListener {
            findNavController().navigate(R.id.action_myNotesFragment_to_selectItemFragment)
        }
    }

    override fun onResume() {
        println("MyNotesFragment: onResume")
        super.onResume()
    }

    override fun onDestroyView() {
        println("MyNotesFragment: onDestroyView()")
        super.onDestroyView()
        _binding = null
    }

    override fun onAttach(context: Context) {
        println("MyNotesFragment: onAttach()")
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        println("MyNotesFragment: onCreate()")
        super.onCreate(savedInstanceState)
    }

    override fun onStart() {
        println("MyNotesFragment: onStart()")
        super.onStart()
    }

    override fun onPause() {
        println("MyNotesFragment: onPause()")
        super.onPause()
    }

    override fun onStop() {
        println("MyNotesFragment: onStop()")
        super.onStop()
    }

    override fun onDestroy() {
        println("MyNotesFragment: onDestroy()")
        super.onDestroy()
    }

    override fun onDetach() {
        println("MyNotesFragment: onDetach()")
        super.onDetach()
    }
}