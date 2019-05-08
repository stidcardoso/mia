package com.teda.miaanticonceptivos.ui

import android.content.Intent
import android.os.Bundle
import android.support.constraint.Group
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.teda.miaanticonceptivos.R
import com.teda.miaanticonceptivos.util.Storage
import com.teda.miaanticonceptivos.data.model.Priority
import kotlinx.android.synthetic.main.activity_select_priorities.*

class SelectPrioritiesActivity : AppCompatActivity() {

    val circles by lazy { arrayListOf<ImageView>(imageView6, imageView7, imageView8, imageView9, imageView10, imageView11) }
    val icons by lazy { arrayListOf<ImageView>(imageTravel, imageStudy, imageWork, imageSon, imageTime, imageAdd) }
    val texts by lazy { arrayListOf<TextView>(textTravel, textStudy, textWork, textSon, textTime, textAdd) }

    val places by lazy { arrayListOf<ImageView>(image1, image2, image3) }
    val textPlaces by lazy { arrayListOf<TextView>(textPlace1, textPlace2, textPlace3) }
    val imagesPlaces by lazy { arrayListOf<ImageView>(imagePlace1, imagePlace2, imagePlace3) }
    val textSelectedPlaces by lazy { arrayListOf<TextView>(textSelected1, textSelected2, textSelected3) }
    val groups by lazy { arrayListOf<Group>(groupPlace1, groupPlace2, groupPlace3) }
    val selected by lazy { arrayListOf<Priority?>(null, null, null) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_priorities)
        include.setOnClickListener {
            if (validate()) {
                /*for (priority in Storage.selectedPriorities) {
                    if (priority!!.id == 3) {
                        Storage.sonSelected = true
                        break
                    }
                    Storage.sonSelected = false
                }*/
                Storage.selectedPriorities = selected
                val f = Storage.selectedPriorities.filter {
                    it?.id == 3
                }
                Storage.sonSelected = !f.isEmpty()
                startActivity(Intent(this, DiscreetActivity::class.java))
            }
        }
        imageView6.setOnClickListener {
            selectPriority(0)
        }
        imageView7.setOnClickListener {
            selectPriority(1)
        }
        imageView8.setOnClickListener {
            selectPriority(2)
        }
        imageView9.setOnClickListener {
            selectPriority(3)
        }
        imageView10.setOnClickListener {
            selectPriority(4)
        }
        imageView11.setOnClickListener {
            selectPriority(5)
        }

        image1.setOnClickListener {
            unselect(0)
        }

        image2.setOnClickListener {
            unselect(1)
        }

        image3.setOnClickListener {
            unselect(2)
        }
    }

    fun selectPriority(position: Int) {
        for (i in 0..5) {
            if (position == i) {
                for (j in 0..2) {
                    if (selected[j] == null) {
                        circles[i].setImageDrawable(ContextCompat.getDrawable(this, R.drawable.circle_orange_shadow))
                        icons[i].setColorFilter(ContextCompat.getColor(this, R.color.white))
                        texts[i].setTextColor(ContextCompat.getColor(this, R.color.orange))

                        selected[j] = Storage.priorities[position]
                        places[j].setImageDrawable(ContextCompat.getDrawable(this, R.drawable.circle_orange_shadow))
                        textPlaces[j].visibility = View.GONE
                        groups[j].visibility = View.VISIBLE
                        imagesPlaces[j].setImageDrawable(ContextCompat.getDrawable(this, Storage.priorities[position].icon))
                        textSelectedPlaces[j].text = Storage.priorities[position].name
                        break
                    }

                }
            }
        }
    }

    fun unselect(position: Int) {
        val sel = selected[position]
        sel?.let {
            circles[sel.id].setImageDrawable(ContextCompat.getDrawable(this, R.drawable.circle_white_shadow))
            icons[sel.id].setColorFilter(ContextCompat.getColor(this, R.color.orange))
            texts[sel.id].setTextColor(ContextCompat.getColor(this, R.color.white))
            places[position].setImageDrawable(ContextCompat.getDrawable(this, R.drawable.circle_gray))
            textPlaces[position].visibility = View.VISIBLE
            groups[position].visibility = View.GONE
            selected[position] = null
        }
    }

    fun validate(): Boolean {
        var b = true
        for (i in 0..2) {
            if (selected[i] == null) {
                b = false
                break
            }
        }
        return b
    }


}
