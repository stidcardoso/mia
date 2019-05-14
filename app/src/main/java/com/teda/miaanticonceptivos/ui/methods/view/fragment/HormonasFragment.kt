package com.teda.miaanticonceptivos.ui.methods.view.fragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.teda.miaanticonceptivos.ui.CompareActivity
import com.teda.miaanticonceptivos.ui.MainActivity
import com.teda.miaanticonceptivos.ui.MainCallback
import com.teda.miaanticonceptivos.R
import kotlinx.android.synthetic.main.fragment_hormonas.*
import kotlinx.android.synthetic.main.fragment_tip.*

class HormonasFragment : Fragment() {

    lateinit var mainCallback: MainCallback

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is MainCallback)
            mainCallback = context
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_hormonas, container, false)
        return v
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        drawer.setOnClickListener {
            mainCallback.openDrawer()
        }
        imageBack.setOnClickListener{
            (activity as MainActivity).onBackPressed()
        }

        imageLight.setOnClickListener {
            tip.visibility = View.VISIBLE
            textTipTitle.text = "TU DISPOSITIVO TE ACOMPAÑA POR EL TIEMPO QUE LO NECESITES DE ACUERDO CON TUS PLANES DE VIDA"
            imageCircle.setImageDrawable(ContextCompat.getDrawable(context!!, R.drawable.circle_purple_shadow))
            imageIcon.setImageDrawable(ContextCompat.getDrawable(context!!, R.drawable.hormonas_res))
        }

        tipInclude.setOnClickListener{
            tip.visibility = View.GONE
        }
        imageCompare.setOnClickListener{
            startActivity(Intent(context, CompareActivity::class.java))
        }
    }

}