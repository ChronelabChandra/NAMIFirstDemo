package com.example.androiddemoapp.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.androiddemoapp.R
import com.example.androiddemoapp.datamodel.Line

class MainActivity : AppCompatActivity() {
    var TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var line : Line = Line(0,0,10,10)
        line.description()

////        val a: Int = 10000
////        val d: Double = 100.00
////        val f: Float = 100.00f
////        val l: Long = 1000000004
////        val s: Short = 10
////        val b: Byte = 1
//
//
//
//        val a = 10000
//        val d = 100.00
//        val f = 100.00f
//        val l = 1000000004
//        val s = 10
//        val b = 1
//
//
//        Log.e(TAG,"Your Int Value is "+a)
//        Log.e(TAG,"Your Double  Value is "+d)
//        Log.e(TAG,"Your Float Value is "+f)
//        Log.e(TAG,"Your Long Value is "+l);
//        Log.e(TAG,"Your Short Value is "+s)
//        Log.e(TAG,"Your Byte Value is "+b)
//
//
//        val letter: Char    // defining a variable
//        letter = 'A'        // Assigning a value to it
//        Log.e(TAG,"$letter")  //        println("\(letter)")  --- Swift
//
//
//        val letterBool: Boolean   // defining a variable
//        letterBool = true         // Assinging a value to it
//        Log.e(TAG,"Your character value is "+"$letterBool")
//
//
//        var rawString :String  = "I am Raw String!"
//        val escapedString : String  = "I am escaped String!\n"
//
//        Log.e(TAG,"Hello!"+escapedString)
//        Log.e(TAG,"Hey!!"+rawString)
//
//
//        val numbers: IntArray = intArrayOf(1, 2, 3, 4, 5)
//        Log.e(TAG,"Hey!! I am array Example"+numbers[2])
//
//
//        val numbersList: MutableList<Int> = mutableListOf(7, 8, 9) //mutable List (Shallow copy deep copy)
//        val readOnlyList: List<Int> = numbersList                  // immutable list, shallow copy
//
//        /*
//        For clone or copy list (deep copy) you can use
//        List -> toList(), Array -> toArray(), ArrayList -> toArray(), MutableList -> toMutableList()
//        **/
//        val cloneList: List<Int> = numbersList.toList()  //Deep copy
//
//        Log.e(TAG,"Mutable List: "+numbersList)        // prints "[1, 2, 3]"
//        numbersList.add(4)
//        Log.e(TAG,"Mutable List after addition: "+numbersList)        // prints "[1, 2, 3, 4]"
//        Log.e(TAG, "Read Only List after addition: "+readOnlyList)
//        Log.e(TAG, "Clone List after addition: "+cloneList)
//
////        numbersList.clear()
////        readOnlyList.clear()    // ⇒ does not compile
////        Log.e(TAG,"Mutable List after clear: "+numbersList)        // prints "[1, 2, 3, 4]"
////        Log.e(TAG, "Read Only List after clear: "+readOnlyList)
////        Log.e(TAG, "Clone List after clear: "+cloneList)
//
//        /*Filter data from list*/
//        Log.e(TAG,"Mutable List after filter: "+numbersList.filter { it % 2 == 0 })        // prints "[1, 2, 3, 4]"
//
//
//        /*For Loop*/
//        for (i in 1..4){
//            Log.e(TAG,"Loop"+i)
//        }
//
//        for ((listIndex, listItem) in numbersList.withIndex()){
////            Log.e(TAG,"Index: "+ listIndex +" List Item: " +listItem)
//            Log.e(TAG,"Index: $listIndex List Item: $listItem")
//        }
//
//        /* Explore while loop, do while loop*/
//
//
//        /*Continue and Break*/
//
//        myLabel@ for(x in 1..10) { // appling the custom label
//            if(x == 5) {
//                Log.e(TAG,"I am inside if block with value"+x+"\n-- hence it will close the operation")
//                break@myLabel //specifing the label
//            } else {
//                Log.e(TAG,"I am inside else block with value"+x)
//                continue@myLabel
//            }
//        }
//
//        /*When condition*/
//        val x:Int = 5
//        when(x){
////            1 -> Log.e(TAG,"Value is"+x)
////            5 -> Log.e(TAG,"Value is "+x)
//            1, 5 -> Log.e(TAG,"Value is either 1 or 5")
//            else -> {
//                Log.e(TAG,"No Match")
//            }
//        }
    }
}