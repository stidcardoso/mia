package com.teda.miaanticonceptivos.ui.form.view

import android.content.Intent
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.teda.miaanticonceptivos.R
import com.teda.miaanticonceptivos.data.local.RealmDao
import com.teda.miaanticonceptivos.util.Storage
import com.teda.miaanticonceptivos.util.Utilities
import kotlinx.android.synthetic.main.activity_discreet.*

class DiscreetActivity : AppCompatActivity() {

    private val realmDao = RealmDao()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_discreet)
        include.setOnClickListener {
            startActivity(Intent(this, SelectDiscreetActivity::class.java))
        }
        Utilities.getImage(Storage.imagesNames[2])?.let { imageBackground.setImageBitmap(it) }
        /*Glide.with(this)
                .load(realmDao.getImage().discreet)
                .error(ContextCompat.getDrawable(this, R.drawable.discreet_background2))
                .into(imageBackground)*/
    }

    override fun onDestroy() {
        super.onDestroy()
        realmDao.closeRealm()
    }
}
