package com.example.androiddemoapp.views.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.androiddemoapp.R
import androidx.lifecycle.Observer
import com.example.androiddemoapp.views.LineViewModel


class LineFragment : Fragment() {

    private lateinit var lineViewModel: LineViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        lineViewModel =
            ViewModelProviders.of(this).get(LineViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_line, container, false)
        val textView: TextView = root.findViewById(R.id.text_line)
        lineViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}