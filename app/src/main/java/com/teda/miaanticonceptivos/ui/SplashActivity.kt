package com.teda.miaanticonceptivos.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import com.teda.miaanticonceptivos.R


class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler().postDelayed(Runnable {
            /* Create an Intent that will start the Menu-Activity. */
            val mainIntent = Intent(this, TutorialActivity::class.java)
            this.startActivity(mainIntent)
            this.finish()
        }, 2000)
    }
}
