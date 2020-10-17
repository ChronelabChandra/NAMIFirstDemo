package com.example.androiddemoapp.views.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.Observer
import com.example.androiddemoapp.R
import com.example.androiddemoapp.views.SquareViewModel


class SquareFragment : Fragment() {

    private lateinit var squareViewModel: SquareViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        squareViewModel =
            ViewModelProviders.of(this).get(SquareViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_square, container, false)
        val textView: TextView = root.findViewById(R.id.text_square)
        squareViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

}