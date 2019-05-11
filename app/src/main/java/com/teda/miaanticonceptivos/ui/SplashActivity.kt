package com.teda.miaanticonceptivos.ui

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.teda.miaanticonceptivos.R
import com.teda.miaanticonceptivos.presenter.SplashContract
import com.teda.miaanticonceptivos.presenter.SplashPresenter


class SplashActivity : AppCompatActivity(), SplashContract.View {

    private val presenter = SplashPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        presenter.getFirebaseData()
        /*Handler().postDelayed(Runnable {
            *//* Create an Intent that will start the Menu-Activity. *//*
            val mainIntent = Intent(this, TutorialActivity::class.java)
            this.startActivity(mainIntent)
            this.finish()
        }, 2000)
*/
    }

    override fun goToNextActivity() {
        val mainIntent = Intent(this, TutorialActivity::class.java)
        this.startActivity(mainIntent)
        this.finish()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDetach()
    }
}
