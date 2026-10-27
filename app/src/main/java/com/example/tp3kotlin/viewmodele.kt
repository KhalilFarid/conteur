package com.example.tp3kotlin
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SimpleViewModel : ViewModel() {
    val text = MutableLiveData(0)
    fun incrementer() {
        text.value = (text.value ?: 0) + 1
    }
    fun decrementer() {
        text.value = (text.value ?: 0)-1
    }
}