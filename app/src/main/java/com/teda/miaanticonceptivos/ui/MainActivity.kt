package com.teda.miaanticonceptivos.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.teda.miaanticonceptivos.App
import com.teda.miaanticonceptivos.R
import com.teda.miaanticonceptivos.ui.home.EmergencyFragment
import com.teda.miaanticonceptivos.ui.home.view.CompareFragment
import com.teda.miaanticonceptivos.ui.home.view.HomeFragment
import com.teda.miaanticonceptivos.ui.home.view.PreventFragment
import com.teda.miaanticonceptivos.ui.methods.view.fragment.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainCallback {

    private var currentFragment: Fragment = HomeFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.container, HomeFragment())
        ft.commit()

        textClose.setOnClickListener {
            slidingPane.closePane()
        }

        imageClose.setOnClickListener {
            slidingPane.closePane()
        }

        textPermanent.setOnClickListener {
            group1.visibility = View.VISIBLE
            group2.visibility = View.GONE
            group3.visibility = View.GONE
        }

        textDuration.setOnClickListener {
            group1.visibility = View.GONE
            group2.visibility = View.VISIBLE
            group3.visibility = View.GONE
        }

        textShort.setOnClickListener {
            group1.visibility = View.GONE
            group2.visibility = View.GONE
            group3.visibility = View.VISIBLE
        }

        textLigadura.setOnClickListener {
            replaceFragment(LigaduraFragment())
            //            startActivity(Intent(this, LigaduraActivity::class.java))
        }

        textVasectomia.setOnClickListener {
            //            startActivity(Intent(this, VasectomiaActivity::class.java))
            replaceFragment(VasectomiaFragment())
        }

        textCobre.setOnClickListener {
            //            startActivity(Intent(this, CobreActivity::class.java))
            replaceFragment(CobreFragment())
        }

        textHormonas.setOnClickListener {
            replaceFragment(HormonasFragment())
//            startActivity(Intent(this, HormonasActivity::class.java))
        }

        textImplante.setOnClickListener {
            replaceFragment(ImplanteFragment())
//            startActivity(Intent(this, ImplanteActivity::class.java))
        }

        textInyectable.setOnClickListener {
            replaceFragment(InyectablesFragment())
//            startActivity(Intent(this, InyectablesActivity::class.java))
        }

        textOrales.setOnClickListener {
            replaceFragment(OralesFragment())
//            startActivity(Intent(this, OralesActivity::class.java))
        }

        textParche.setOnClickListener {
            replaceFragment(ParcheFragment())
//            startActivity(Intent(this, ParcheActivity::class.java))
        }

        textAnillo.setOnClickListener {
            replaceFragment(AnilloFragment())
//            startActivity(Intent(this, AnilloActivity::class.java))
        }

        textEmergency.setOnClickListener {
            replaceFragment(EmergencyFragment())
            //            replaceFragment(VasectomiaFragment())
//            startActivity(Intent(this, EmergencyActivity::class.java))
        }

        textPrevention.setOnClickListener {
            replaceFragment(PreventFragment())
            //            startActivity(Intent(this, PreventActivity::class.java))
        }

        textCompare.setOnClickListener {
            replaceFragment(CompareFragment())
            //            startActivity(Intent(this, AnilloActivity::class.java))
        }

        textResults.setOnClickListener {
            replaceFragment(AnalyticsFragment())
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        App.eventUtil.setCurrentScreen(this, fragment)
        currentFragment = fragment
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.container, fragment)
        ft.commit()
        slidingPane.closePane()
    }

    override fun openDrawer() {
        slidingPane.openPane()
    }

    override fun goDetail(fragment: Fragment) {
        replaceFragment(fragment)
    }

    override fun onBackPressed() {
        if (currentFragment is HomeFragment)
            super.onBackPressed()
        else
            replaceFragment(HomeFragment())
    }

}