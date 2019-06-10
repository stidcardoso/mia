package com.teda.miaanticonceptivos.ui.home

import android.content.Intent
import android.support.v4.app.Fragment
import android.view.View
import com.teda.miaanticonceptivos.ui.CompareActivity
import com.teda.miaanticonceptivos.ui.MainActivity
import com.teda.miaanticonceptivos.ui.pricing.view.PricingActivity
import kotlinx.android.synthetic.main.component_side_bar.view.*

class DrawerHelper(val view: View, fragment: Fragment) {

    init {
        view.imageBack.setOnClickListener {
            (fragment.activity as MainActivity).onBackPressed()
        }

        view.imageCompare.setOnClickListener {
            fragment.startActivity(Intent(fragment.context, PricingActivity::class.java))
        }

    }

}