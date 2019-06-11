package com.teda.miaanticonceptivos.ui.form.view

import android.content.Intent
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.teda.miaanticonceptivos.R
import com.teda.miaanticonceptivos.data.local.RealmDao
import kotlinx.android.synthetic.main.activity_time.*

class TimeActivity : AppCompatActivity() {

    private val realmDao = RealmDao()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_time)

        include.setOnClickListener {
            startActivity(Intent(this, SelectTimeActivity::class.java))
        }
        /*Glide.with(this)
                .load(realmDao.getImage().priority)
                .error(ContextCompat.getDrawable(this, R.drawable.time_background))
                .into(imageBackground)*/
    }

    override fun onDestroy() {
        super.onDestroy()
        realmDao.closeRealm()
    }

}