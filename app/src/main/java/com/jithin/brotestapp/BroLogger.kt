package com.jithin.brotestapp

import android.util.Log

object BroLogger {

    val vm = SecondActivityViewModel()
    fun printLog(message: String?) {
        Log.d("DEBUG", "BRO_DEBUG :=> $message")
    }
}