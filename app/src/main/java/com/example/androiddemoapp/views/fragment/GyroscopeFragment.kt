package com.example.androiddemoapp.views.fragment

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.androiddemoapp.R


class GyroscopeFragment : Fragment(), SensorEventListener {

    val TAG = "GyroscopeFragment"

    private lateinit var sensorManager: SensorManager
    private var lastUpdate: Long = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_gyroscope, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sensorManager = requireContext().getSystemService(Context.SENSOR_SERVICE) as SensorManager
        lastUpdate = System.currentTimeMillis()
    }

    override fun onSensorChanged(event: SensorEvent?) {
        if (event?.sensor?.getType() == Sensor.TYPE_ACCELEROMETER) {
            getAccelerometer(event);
        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
    }


    private fun getAccelerometer(event: SensorEvent) {
        val values = event.values
        // Movement
        val x = values[0]
        val y = values[1]
        val z = values[2]
        /* val accelationSquareRoot = ((x * x + y * y + z * z)
                 / (SensorManager.GRAVITY_EARTH * SensorManager.GRAVITY_EARTH))
         val actualTime = event.timestamp
         if (accelationSquareRoot >= 2) //
         {
             if (actualTime - lastUpdate < 200) {
                 return
             }
             lastUpdate = actualTime
             Toast.makeText(requireContext(), "Device was shuffed", Toast.LENGTH_SHORT).show()
         }*/

        Log.i(TAG, "X: $x Y: $y Z: $z")
    }
}