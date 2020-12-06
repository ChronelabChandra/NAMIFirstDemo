package com.example.androiddemoapp.views.fragment

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.androiddemoapp.R
import androidx.lifecycle.Observer


class LineFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_line, container, false)
//        val textView: TextView = root.findViewById(R.id.text_line)

        return root
    }

    override fun onResume() {
        super.onResume()
        drawLine()
    }

    private fun drawLine() {
        val bitmap = Bitmap.createBitmap(1000, 1000, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)
        canvas.drawColor(Color.RED)

        // Holds the style and color informations about hot to draw geometries
        val paint = Paint()
        paint.color = Color.BLACK
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 2f
        paint.isAntiAlias = true

        val offset = 50
        canvas.drawLine(
            offset.toFloat(),
            canvas.height / 2.toFloat(),
            canvas.width - offset.toFloat(),
            canvas.height / 2.toFloat(),
            paint)

        val imageView = ImageView(this)
        imageView.setImageBitmap(bitmap)
        drawLayout.removeAllViews()
        drawLayout.addView(imageView)
    }
}