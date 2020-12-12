package com.example.androiddemoapp.views.fragment

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import com.example.androiddemoapp.R

/**
 * A simple [Fragment] subclass.
 * Use the [CircleFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CircleFragment : Fragment() {
    private lateinit var drawLayout: LinearLayout
    private lateinit var btnDrawLine: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_circle, container, false)
        drawLayout = root.findViewById(R.id.drawLayout)
        btnDrawLine = root.findViewById(R.id.btnDrawLine)
        btnDrawLine.setOnClickListener {
            drawCircle()
        }
        return root
    }

    override fun onResume() {
        super.onResume()
    }

    private fun drawCircle() {
        val bitmap = Bitmap.createBitmap(1000, 1000, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)
        canvas.drawColor(Color.RED)

        val paint = Paint()
        paint.color = Color.BLACK
        paint.strokeWidth = 10F
        paint.style = Paint.Style.STROKE
        paint.isAntiAlias = true
        paint.isDither = true


        canvas.drawCircle(canvas.height / 2.toFloat(), canvas.width / 2.toFloat(), 300f, paint)

        val imageView = ImageView(activity)
        imageView.setImageBitmap(bitmap)

        drawLayout.removeAllViews()
        drawLayout.addView(imageView)


    }

//    private fun drawCircle() {
//        val bitmap = Bitmap.createBitmap(1000, 1000, Bitmap.Config.ARGB_8888)
//        val canvas = Canvas(bitmap)
//        canvas.drawColor(Color.RED)
//
//        // Holds the style and color informations about hot to draw geometries
//        val paint = Paint()
//        paint.color = Color.BLACK
//        paint.style = Paint.Style.STROKE
//        paint.strokeWidth = 8f
//        paint.isAntiAlias = true
//
//        val offset = 50
//        canvas.drawLine(
//            offset.toFloat(),
//            canvas.height / 2.toFloat(),
//            canvas.width - offset.toFloat(),
//            canvas.height / 2.toFloat(),
//            paint)
//
//        val imageView = ImageView(activity)
//        imageView.setImageBitmap(bitmap)
//        drawLayout.removeAllViews()
//        drawLayout.addView(imageView)
//    }
}