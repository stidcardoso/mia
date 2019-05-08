package com.teda.miaanticonceptivos.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.teda.miaanticonceptivos.R
import kotlinx.android.synthetic.main.activity_guide.*

class CompareActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_compare)
        include.setOnClickListener {
            onBackPressed()
        }
    }
}
