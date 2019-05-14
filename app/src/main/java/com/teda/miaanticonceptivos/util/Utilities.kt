package com.teda.miaanticonceptivos.util

import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit

object Utilities {

    var startTime: Long? = null

    fun startingTime() {
        startTime = System.nanoTime()
    }

    fun endTime(): Int {
        var endTime = System.nanoTime()
        endTime = (endTime - startTime!!)
        val seconds = TimeUnit.NANOSECONDS.toSeconds(endTime)
        return seconds.toInt()
    }

    /*fun getCurrentDate(): String? {
        val sdf = SimpleDateFormat("dd/MM/yyyy")
        return sdf.format(Date())
    }*/

}