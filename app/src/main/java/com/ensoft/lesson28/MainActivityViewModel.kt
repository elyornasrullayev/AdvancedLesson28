package com.ensoft.lesson28

import android.os.CountDownTimer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel: ViewModel() {
//    var number = 0
//    fun increment(){
//        number++
//    }
//    fun decrement(){
//        number--
//    }


//    private var username = MutableLiveData<String>()
//
//    fun setUsername(string: String){
//        //username ni o'zgartirish uchun
//        username.value = string
//    }
//
//    fun getUsername(): LiveData<String> {
//        return username
//    }

    var secondsLeft:Long = 0
    private lateinit var countDownTimer: CountDownTimer
    private var time = MutableLiveData<Int>()

    private var isFinished = MutableLiveData<Boolean>()

    fun getTime(): LiveData<Int>{
        return time
    }

    fun getTimerStatus(): LiveData<Boolean>{
        return isFinished
    }

    fun startTimer(){
        countDownTimer = object : CountDownTimer(15000,1000) {
            override fun onTick(p0: Long) {
                secondsLeft = p0/1000
                time.value = secondsLeft.toInt()
            }

            override fun onFinish() {
                isFinished.value = true
            }

        }.start()
    }
    fun stopTimer(){
        time.value = 0
        countDownTimer.cancel()
    }
}