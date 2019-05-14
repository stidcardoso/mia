package com.teda.miaanticonceptivos.ui.form.view

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.teda.miaanticonceptivos.R
import com.teda.miaanticonceptivos.util.Utilities
import kotlinx.android.synthetic.main.activity_priority.*

class PrioritiesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_priority)
        include.setOnClickListener{
            startActivity(Intent(this, SelectPrioritiesActivity::class.java))
            Utilities.startingTime()
        }
    }
}
