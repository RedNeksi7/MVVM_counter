package com

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModel : ViewModel() {

    var IsDark = MutableLiveData<Boolean>(false)
    val counter = MutableLiveData<Int>(0)

    fun increment() {
        counter.postValue(counter.value!! + 1)
    }

    fun decrement() {
        counter.postValue(counter.value!! - 1)
    }

    fun onThemeClick(){
        IsDark.value = !IsDark.value!!
    }
}