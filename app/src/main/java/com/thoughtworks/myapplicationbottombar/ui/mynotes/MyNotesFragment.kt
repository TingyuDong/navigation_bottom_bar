package com.thoughtworks.myapplicationbottombar.ui.mynotes

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.thoughtworks.myapplicationbottombar.R

class MyNotesFragment : Fragment() {

    private lateinit var viewModel: MyNotesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        println("MyNotesFragment: onCreateView")
        return inflater.inflate(R.layout.fragment_my_notes, container, false)
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
        view?.findViewById<Button>(R.id.btn_my_notes)?.setOnClickListener {
            findNavController().navigate(R.id.mathFragment)
        }
    }

    override fun onResume() {
        println("MyNotesFragment: onResume")
        super.onResume()
    }

    override fun onDestroyView() {
        println("MyNotesFragment: onDestroyView()")
        super.onDestroyView()
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