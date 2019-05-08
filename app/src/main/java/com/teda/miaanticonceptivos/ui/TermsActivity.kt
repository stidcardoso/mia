package com.teda.miaanticonceptivos.ui

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.teda.miaanticonceptivos.R
import kotlinx.android.synthetic.main.activity_terms.*

class TermsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_terms)
        imageView4.setOnClickListener {
            startActivity(Intent(this, PrioritiesActivity::class.java))
        }
    }
}
