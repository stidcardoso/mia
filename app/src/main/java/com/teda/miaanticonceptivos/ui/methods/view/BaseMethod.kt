package com.teda.miaanticonceptivos.ui.methods.view

import android.content.Context
import android.os.Handler
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import com.teda.miaanticonceptivos.R

class BaseMethod(context: Context, tip: ImageView) {

    init {
        val fadeIn = AnimationUtils.loadAnimation(context, R.anim.fade_in)
        val fadeOut = AnimationUtils.loadAnimation(context, R.anim.fade_out)
        tip.startAnimation(fadeIn)
        fadeIn.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationRepeat(p0: Animation?) {
            }

            override fun onAnimationEnd(p0: Animation?) {
                Handler().postDelayed({
                    tip.startAnimation(fadeOut)
                }, 10000)
            }

            override fun onAnimationStart(p0: Animation?) {
            }

        })

        fadeOut.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationRepeat(p0: Animation?) {
            }

            override fun onAnimationEnd(p0: Animation?) {
                Handler().postDelayed({
                    tip.startAnimation(fadeIn)
                }, 10000)
            }

            override fun onAnimationStart(p0: Animation?) {
            }

        })
    }

}