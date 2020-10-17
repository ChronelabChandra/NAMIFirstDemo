package com.example.androiddemoapp.views

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LineViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is line Fragment"
    }
    val text: LiveData<String> = _text
}