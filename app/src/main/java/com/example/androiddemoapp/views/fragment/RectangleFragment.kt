package com.example.androiddemoapp.views.fragment



import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.androiddemoapp.R
import com.example.androiddemoapp.views.RectangleViewModel

class RectangleFragment : Fragment() {

    private lateinit var rectangleViewModel: RectangleViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rectangleViewModel =
            ViewModelProviders.of(this).get(RectangleViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_rectangle, container, false)
        val textView: TextView = root.findViewById(R.id.text_rectangle)
        rectangleViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}