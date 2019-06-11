package com.teda.miaanticonceptivos.util

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import com.teda.miaanticonceptivos.App
import java.io.File
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

    fun getImage(name: String): Bitmap? {
        return try {
            val file = File(App.app!!.applicationContext.filesDir, "$name.png")
            if (file.exists())
                BitmapFactory.decodeFile(file.absolutePath)
            else
                null
        } catch (e: Exception) {
            null
        }
    }

    /*fun getCurrentDate(): String? {
        val sdf = SimpleDateFormat("dd/MM/yyyy")
        return sdf.format(Date())
    }*/

}