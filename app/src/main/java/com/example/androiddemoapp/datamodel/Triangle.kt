package com.example.androiddemoapp.datamodel

import android.util.Log

class Triangle {
    var TAG = "Triangle"

    private var x1: Int = 0
    private var y1: Int = 0
    private var x2: Int = 0
    private var y2: Int = 0
    private var x3: Int = 0
    private var y3: Int = 0

    constructor(x1: Int, y1: Int, x2: Int, y2: Int, x3: Int, y3: Int) {
        this.x1 = x1
        this.y1 = y1
        this.x2 = x2
        this.y2 = y2
        this.x3 = x3
        this.y3 = y3
    }


    fun description(){
        Log.e(TAG, "Triangle: [ $x1, $y1 ] , [$x2, $y2] , [$x3, $y3]")
    }
}