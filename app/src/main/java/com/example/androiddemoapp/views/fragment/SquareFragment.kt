package com.example.androiddemoapp.views.fragment

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.RectShape
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.Observer
import com.example.androiddemoapp.R


class SquareFragment : Fragment() {
    private lateinit var drawLayout: LinearLayout
    private lateinit var btnDrawLine: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_square, container, false)
        drawLayout = root.findViewById(R.id.drawLayout)
        btnDrawLine = root.findViewById(R.id.btnDrawLine)
        btnDrawLine.setOnClickListener {
            drawSquare()
        }
        return root
    }


    private fun drawSquare() {
        val bitmap: Bitmap = Bitmap.createBitmap(1000, 1000, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)
        canvas.drawColor(Color.RED)

        val shapeDrawable = ShapeDrawable(RectShape())  //OvalShape()
        shapeDrawable.setBounds(100, 100, 600, 600)

        shapeDrawable.paint.color = Color.BLACK
        shapeDrawable.paint.style = Paint.Style.STROKE
        shapeDrawable.paint.strokeWidth = 10f
        shapeDrawable.draw(canvas)

        val imageView = ImageView(activity)
        imageView.setImageBitmap(bitmap)

        drawLayout.removeAllViews()
        drawLayout.addView(imageView)
    }

}