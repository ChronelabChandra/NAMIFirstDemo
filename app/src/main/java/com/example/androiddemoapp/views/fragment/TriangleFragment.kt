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
import com.example.androiddemoapp.views.TriangleViewModel

class TriangleFragment : Fragment() {

    private lateinit var triangleViewModel: TriangleViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        triangleViewModel =
            ViewModelProviders.of(this).get(TriangleViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_triangle, container, false)
        val textView: TextView = root.findViewById(R.id.text_triangle)
        triangleViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}