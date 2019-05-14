package com.teda.miaanticonceptivos.ui.form.view

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.teda.miaanticonceptivos.R
import kotlinx.android.synthetic.main.activity_time.*

class TimeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_time)

        include.setOnClickListener {
            startActivity(Intent(this, SelectTimeActivity::class.java))
        }
    }

}