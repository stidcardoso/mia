package com.teda.miaanticonceptivos.ui.form.view

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import com.teda.miaanticonceptivos.R
import com.teda.miaanticonceptivos.ui.form.presenter.SplashContract
import com.teda.miaanticonceptivos.ui.form.presenter.SplashPresenter


class SplashActivity : AppCompatActivity(), SplashContract.View {

    private val presenter = SplashPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        presenter.getFirebaseData()
    }

    override fun goToNextActivity() {
        val mainIntent = Intent(this, TutorialActivity::class.java)
        this.startActivity(mainIntent)
        this.finish()
    }

    override fun loadNormalSplash() {
        Handler().postDelayed({
            val mainIntent = Intent(this, TutorialActivity::class.java)
            this.startActivity(mainIntent)
            this.finish()
        }, 2000)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDetach()
    }
}
