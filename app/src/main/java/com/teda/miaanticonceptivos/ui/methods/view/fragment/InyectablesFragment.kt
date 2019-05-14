package com.teda.miaanticonceptivos.ui.methods.view.fragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.teda.miaanticonceptivos.ui.CompareActivity
import com.teda.miaanticonceptivos.ui.MainActivity
import com.teda.miaanticonceptivos.ui.MainCallback
import com.teda.miaanticonceptivos.R
import kotlinx.android.synthetic.main.fragment_inyectables.*

class InyectablesFragment : Fragment() {

    lateinit var mainCallback: MainCallback

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is MainCallback)
            mainCallback = context
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_inyectables, container, false)
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
        imageCompare.setOnClickListener{
            startActivity(Intent(context, CompareActivity::class.java))
        }
    }

}