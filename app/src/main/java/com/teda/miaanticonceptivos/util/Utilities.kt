package com.teda.miaanticonceptivos.util

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

}