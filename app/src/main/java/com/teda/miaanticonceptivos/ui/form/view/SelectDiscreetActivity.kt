package com.teda.miaanticonceptivos.ui.form.view

import android.content.Intent
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.teda.miaanticonceptivos.R
import com.teda.miaanticonceptivos.util.Storage
import kotlinx.android.synthetic.main.activity_select_discreet.*

class SelectDiscreetActivity : AppCompatActivity() {

    var selected = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_discreet)
        include.setOnClickListener {
            if (selected)
                startActivity(Intent(this, TimeActivity::class.java))
        }

        constraint1.setOnClickListener {
            Storage.discreetSelected = 0
            selected(1)
            restoreDefault(2)
            restoreDefault(3)
        }

        constraint2.setOnClickListener {
            Storage.discreetSelected = 0
            selected(2)
            restoreDefault(1)
            restoreDefault(3)
        }

        constraint3.setOnClickListener {
            Storage.discreetSelected = 2
            selected(3)
            restoreDefault(1)
            restoreDefault(2)
        }
    }

    fun selected(position: Int) {
        selected = true
        when (position) {
            1 -> {
                constraint1.background = ContextCompat.getDrawable(this, R.drawable.orange_card)
                imageBackground1.visibility = View.GONE
                imageIcon1.setColorFilter(ContextCompat.getColor(this, R.color.white))
                viewCareless.visibility = View.VISIBLE
            }
            2 -> {
                constraint2.background = ContextCompat.getDrawable(this, R.drawable.orange_card)
                imageBackground2.visibility = View.GONE
                imageIcon2.setColorFilter(ContextCompat.getColor(this, R.color.white))
                viewDiscreet.visibility = View.VISIBLE
            }
            3 -> {
                constraint3.background = ContextCompat.getDrawable(this, R.drawable.orange_card)
                imageBackground3.visibility = View.GONE
                imageIcon3.setColorFilter(ContextCompat.getColor(this, R.color.white))
                viewXDiscreet.visibility = View.VISIBLE
            }
        }
    }

    fun restoreDefault(position: Int) {
        when (position) {
            1 -> {
                constraint1.background = ContextCompat.getDrawable(this, R.drawable.border_gray)
                imageBackground1.visibility = View.VISIBLE
                imageIcon1.colorFilter = null
                viewCareless.visibility = View.GONE
            }
            2 -> {
                constraint2.background = ContextCompat.getDrawable(this, R.drawable.border_gray)
                imageBackground2.visibility = View.VISIBLE
                imageIcon2.colorFilter = null
                viewDiscreet.visibility = View.GONE
            }
            3 -> {
                constraint3.background = ContextCompat.getDrawable(this, R.drawable.border_gray)
                imageBackground3.visibility = View.VISIBLE
                imageIcon3.colorFilter = null
                viewXDiscreet.visibility = View.GONE
            }
        }
    }


}
