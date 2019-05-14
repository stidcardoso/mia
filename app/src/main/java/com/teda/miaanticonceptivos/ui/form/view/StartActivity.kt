package com.teda.miaanticonceptivos.ui.form.view

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.teda.miaanticonceptivos.R
import kotlinx.android.synthetic.main.activity_start.*

class StartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)
        include.setOnClickListener{
            startActivity(Intent(this, TermsActivity::class.java))
        }
    }
}
