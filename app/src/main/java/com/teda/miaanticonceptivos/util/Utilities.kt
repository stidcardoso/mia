package com.teda.miaanticonceptivos.util

import java.text.NumberFormat
import java.util.*
import java.util.concurrent.TimeUnit

object Utilities {

    private var startTime: Long? = null

    fun startingTime() {
        startTime = System.nanoTime()
    }

    fun endTime(): Int {
        var endTime = System.nanoTime()
        endTime = (endTime - startTime!!)
        val seconds = TimeUnit.NANOSECONDS.toSeconds(endTime)
        return seconds.toInt()
    }

    fun getCurrency(amount: String): String {
        return try {
            val format = NumberFormat.getInstance(Locale.US)
            "$ " + format.format(amount.toInt())
        } catch (e: NumberFormatException) {
            e.message
            ""
        }
    }

    /*fun getCurrentDate(): String? {
        val sdf = SimpleDateFormat("dd/MM/yyyy")
        return sdf.format(Date())
    }*/

}