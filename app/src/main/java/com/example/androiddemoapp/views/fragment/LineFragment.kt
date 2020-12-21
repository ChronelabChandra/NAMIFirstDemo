package com.example.androiddemoapp.views.fragment

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import com.example.androiddemoapp.R
import kotlinx.android.synthetic.main.fragment_line.*


class LineFragment : Fragment(), View.OnTouchListener {
    private lateinit var root: View
    private lateinit var drawLayout: LinearLayout
    private lateinit var btnDrawLine: Button

    private lateinit var imageView: ImageView
    lateinit var bitmap: Bitmap
    lateinit var canvas: Canvas
    lateinit var paint: Paint
    var downx = 0f
    var downy = 0f
    var upx = 0f
    var upy = 0f

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        root = inflater.inflate(R.layout.fragment_line, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //        val textView: TextView = root.findViewById(R.id.text_line)
        drawLayout = root.findViewById(R.id.drawLayout)
        btnDrawLine = root.findViewById(R.id.btnDrawLine)
        btnDrawLine.setOnClickListener {
            drawLine()
        }

        imageView = root.findViewById(R.id.imageView)
        val currentDisplay: Display = requireActivity().windowManager.defaultDisplay
        val dw = currentDisplay.width.toFloat()
        val dh = currentDisplay.height.toFloat()

        /*bitmap = Bitmap.createBitmap(
            dw.toInt(), dh.toInt(),
            Bitmap.Config.ARGB_8888
        )*/

        dragDrawLayout.post {
            bitmap = Bitmap.createBitmap(
                dragDrawLayout.width, dragDrawLayout.height,
                Bitmap.Config.ARGB_8888
            )
            canvas = Canvas(bitmap)
            paint = Paint()
            paint.color = Color.BLACK
            paint.strokeWidth = 10f
            imageView.setImageBitmap(bitmap)

            imageView.setOnTouchListener(this)
        }


    }


    override fun onResume() {
        super.onResume()
//        drawLine()
    }

    private fun drawLine() {
        val bitmap = Bitmap.createBitmap(1000, 1000, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)
        canvas.drawColor(Color.RED)

        // Holds the style and color informations about hot to draw geometries
        val paint = Paint()
        paint.color = Color.BLACK
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 8f
        paint.isAntiAlias = true

        val offset = 50
        canvas.drawLine(
            offset.toFloat(),
            canvas.height / 2.toFloat(),
            canvas.width - offset.toFloat(),
            canvas.height / 2.toFloat(),
            paint
        )

        val imageView = ImageView(activity)
        imageView.setImageBitmap(bitmap)
        drawLayout.removeAllViews()
        drawLayout.addView(imageView)
    }

    override fun onTouch(v: View, event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                downx = event.x
                downy = event.y
            }

            MotionEvent.ACTION_MOVE -> {
            }

            MotionEvent.ACTION_UP -> {
                upx = event.x
                upy = event.y
                canvas.drawLine(downx, downy, upx, upy, paint)
                imageView.invalidate()
            }

            MotionEvent.ACTION_CANCEL -> {
            }
        }
        return true
    }

}