package com.example.dadok.ui

import androidx.lifecycle.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashViewModel : ViewModel(){
    val liveData: MutableLiveData<Boolean> = MutableLiveData()

    fun initSplashScreen() {
        viewModelScope.launch {
            delay(1500)
            liveData.value = true
        }
    }

}

