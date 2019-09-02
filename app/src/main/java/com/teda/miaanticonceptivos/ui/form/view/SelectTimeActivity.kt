package com.teda.miaanticonceptivos.ui.form.view

import android.content.Intent
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.TextView
import com.teda.miaanticonceptivos.App
import com.teda.miaanticonceptivos.R
import com.teda.miaanticonceptivos.ui.KnowActivity
import com.teda.miaanticonceptivos.util.Storage
import kotlinx.android.synthetic.main.activity_select_time.*

class SelectTimeActivity : AppCompatActivity() {

    private val constraints by lazy { arrayListOf<ConstraintLayout>(constraint1, constraint2, constraint3, constraint5, constraint6, constraint7) }
    private val textViews by lazy { arrayListOf<TextView>(textView1, textView2, textView3, textView5, textView6, textView7) }
    private val images by lazy { arrayListOf<ImageView>(image1, image2, image3, image5, image6, image7) }
    private var selected = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_time)
        include.setOnClickListener {
            if (selected) {
                App.eventUtil.endQuestions()
                startActivity(Intent(this, KnowActivity::class.java))
            }
        }

        constraint1.setOnClickListener {
            Storage.selectedTime = 0
            selected(0)
        }

        constraint2.setOnClickListener {
            Storage.selectedTime = 1
            selected(1)
        }

        constraint3.setOnClickListener {
            Storage.selectedTime = 3
            selected(2)
        }

        /*   constraint4.setOnClickListener {
               selected(3)
           }*/

        constraint5.setOnClickListener {
            Storage.selectedTime = 36
            selected(3)
        }

        constraint6.setOnClickListener {
            Storage.selectedTime = 60
            selected(4)
        }

        constraint7.setOnClickListener {
            Storage.selectedTime = 1000
            selected(5)
        }
        /*  seekProgress.setOnTouchListener { _, _ ->
              return@setOnTouchListener true
          }*/
        seekProgress.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {

            override fun onProgressChanged(p0: SeekBar?, progress: Int, p2: Boolean) {
                val sp = 1000 / 6
                when (progress) {
                    in 0..sp -> {
                        Storage.selectedTime = 0
                        selected(0, false)
                    }
                    in (sp + 1)..(sp * 2) -> {
                        Storage.selectedTime = 1
                        selected(1, false)
                    }
                    in ((sp * 2) + 1)..(sp * 3) -> {
                        Storage.selectedTime = 3
                        selected(2, false)
                    }
                    in ((sp * 3) + 1)..(sp * 4) -> {
                        Storage.selectedTime = 36
                        selected(3, false)
                    }
                    in ((sp * 4) + 1)..(sp * 5) -> {
                        Storage.selectedTime = 60
                        selected(4, false)
                    }
                    in ((sp * 5) + 1)..(sp * 6) -> {
                        Storage.selectedTime = 1000
                        selected(5, false)
                    }
                }
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
            }

        })

    }

    private fun selected(position: Int, setProgress: Boolean = true) {
        if (setProgress) {
            val progress = ((1000.0 / 6) * (position + 1) - (1000.0 / 12))
            seekProgress.progress = progress.toInt()
        }
        selected = true
        for (i in 0..5) {
            if (i == position) {
                constraints[i].background = ContextCompat.getDrawable(this, R.drawable.orange_card)
                textViews[i].setTextColor(ContextCompat.getColor(this, R.color.white))
                images[i].setColorFilter(ContextCompat.getColor(this, R.color.white))
            } else {
                constraints[i].background = null
                textViews[i].setTextColor(ContextCompat.getColor(this, R.color.orange))
                images[i].setColorFilter(ContextCompat.getColor(this, R.color.orange))
            }
        }
    }

}
