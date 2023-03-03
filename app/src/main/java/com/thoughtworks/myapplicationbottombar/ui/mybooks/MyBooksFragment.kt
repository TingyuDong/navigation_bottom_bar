package com.thoughtworks.myapplicationbottombar.ui.mybooks

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.thoughtworks.myapplicationbottombar.R
import com.thoughtworks.myapplicationbottombar.ui.innerfragmentcontainer.InnerFragmentContainer

class MyBooksFragment : Fragment() {

    private lateinit var viewModel: MyBooksViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        println("MyBooksFragment: onCreateView()")
        return inflater.inflate(R.layout.fragment_my_books, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        println("MyBooksFragment: onActivityCreated()")
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MyBooksViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onAttach(context: Context) {
        println("MyBooksFragment: onAttach()")
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        println("MyBooksFragment: onCreate()")
        super.onCreate(savedInstanceState)
    }

    override fun onStart() {
        println("MyBooksFragment: onStart()")
        super.onStart()
    }

    override fun onResume() {
        println("MyBooksFragment: onResume()")
        super.onResume()
    }

    override fun onPause() {
        println("MyBooksFragment: onPause()")
        super.onPause()
    }

    override fun onStop() {
        println("MyBooksFragment: onStop()")
        super.onStop()
    }

    override fun onDestroy() {
        println("MyBooksFragment: onDestroy()")
        super.onDestroy()
    }

    override fun onDetach() {
        println("MyBooksFragment: onDetach()")
        super.onDetach()
    }

    override fun onDestroyView() {
        println("MyBooksFragment: onDestroyView()")
        super.onDestroyView()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        println("MyBooksFragment: onViewCreated()")
        super.onViewCreated(view, savedInstanceState)
        addBtnEvent(view)
    }

    private fun addBtnEvent(view: View) {
        view.findViewById<Button>(R.id.btn_my_notes).setOnClickListener {
            println("activity supportFragmentManager " + activity?.supportFragmentManager)
            println("parent FragmentManager$parentFragmentManager")
            activity?.supportFragmentManager?.run {
                beginTransaction()
                    .add(R.id.nav_host_fragment_activity_main, InnerFragmentContainer::class.java, Bundle())
                    .addToBackStack("home")
                    // ?.setReorderingAllowed(true)
                    .commit()
            }
        }
    }
}