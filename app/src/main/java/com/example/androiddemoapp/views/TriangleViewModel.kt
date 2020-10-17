package com.example.androiddemoapp.views

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TriangleViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is triangle Fragment"
    }
    val text: LiveData<String> = _text
}