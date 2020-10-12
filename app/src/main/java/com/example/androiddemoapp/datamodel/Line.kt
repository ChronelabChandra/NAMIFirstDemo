package com.example.androiddemoapp.datamodel

import android.util.Log

class Line {
    var TAG = "Line"

    private var x1: Int = 0
    private var y1: Int = 0
    private var x2: Int = 0
    private var y2: Int = 0

    constructor() {

    }
    constructor(x1: Int, y1: Int, x2: Int, y2: Int) {
        this.x1 = x1
        this.y1 = y1
        this.x2 = x2
        this.y2 = y2
    }


    fun description(){
        Log.e(TAG, "Line: [ $x1, $y1 ] to  [$x2, $y2]")
    }


}