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
import android.widget.*
import androidx.fragment.app.Fragment
import com.example.androiddemoapp.R
import kotlinx.android.synthetic.main.fragment_rectangle.*

class RectangleFragment : Fragment() {

    private lateinit var drawLayout: LinearLayout
    private lateinit var btnDrawLine: Button
    private lateinit var txtProgress: TextView
    private lateinit var seekBar: SeekBar

    private var strokeWidth = 3

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_rectangle, container, false)

        drawLayout = root.findViewById(R.id.drawLayout)
        btnDrawLine = root.findViewById(R.id.btnDrawLine)
        seekBar = root.findViewById(R.id.seekBar)
        txtProgress = root.findViewById(R.id.txtProgress)
        txtProgress.text = "Value: $strokeWidth"

        btnDrawLine.setOnClickListener {
            drawRectangle()
        }

        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int,
                                           fromUser: Boolean) {
//                Toast.makeText(activity, "seekbar progress: $progress", Toast.LENGTH_SHORT).show()
                strokeWidth = progress
                txtProgress.text = "Value: $strokeWidth"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
//                Toast.makeText(activity, "seekbar touch started!", Toast.LENGTH_SHORT).show()
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
//                Toast.makeText(activity, "seekbar touch stopped!", Toast.LENGTH_SHORT).show()
            }
        })

        return root
    }

    private fun drawRectangle() {
        val bitmap: Bitmap = Bitmap.createBitmap(1000, 1000, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)
        canvas.drawColor(Color.RED)


        val shapeDrawable = ShapeDrawable(RectShape())  //OvalShape()
        shapeDrawable.setBounds(100, 100, 600, 400)

        shapeDrawable.paint.color = Color.BLACK
        shapeDrawable.paint.style = Paint.Style.STROKE
        shapeDrawable.paint.strokeWidth = strokeWidth.toFloat()
        shapeDrawable.draw(canvas)

        val imageView = ImageView(activity)
        imageView.setImageBitmap(bitmap)

        drawLayout.removeAllViews()
        drawLayout.addView(imageView)
    }
}