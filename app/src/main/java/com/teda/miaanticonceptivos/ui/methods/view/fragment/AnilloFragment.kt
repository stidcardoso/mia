package com.teda.miaanticonceptivos.ui.methods.view.fragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.teda.miaanticonceptivos.R
import com.teda.miaanticonceptivos.data.FbConstants
import com.teda.miaanticonceptivos.data.model.Method
import com.teda.miaanticonceptivos.data.model.Params
import com.teda.miaanticonceptivos.ui.CompareActivity
import com.teda.miaanticonceptivos.ui.MainActivity
import com.teda.miaanticonceptivos.ui.MainCallback
import com.teda.miaanticonceptivos.ui.methods.presenter.BaseMethodContract
import com.teda.miaanticonceptivos.ui.methods.presenter.BaseMethodPresenter
import com.teda.miaanticonceptivos.ui.methods.view.BasicAdapter
import kotlinx.android.synthetic.main.component_side_bar.*
import kotlinx.android.synthetic.main.fragment_anillo.*

class AnilloFragment : Fragment(), BaseMethodContract.View {

    lateinit var mainCallback: MainCallback
    private val presenter by lazy { BaseMethodPresenter(this) }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is MainCallback)
            mainCallback = context
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_anillo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.getMethod(FbConstants.ANILLO)
        drawer.setOnClickListener {
            mainCallback.openDrawer()
        }
        imageBack.setOnClickListener {
            (activity as MainActivity).onBackPressed()
        }
        imageCompare.setOnClickListener {
            startActivity(Intent(context, CompareActivity::class.java))
        }
    }

    override fun showMethod(method: Method) {
        val details = method.details
        val featuresAdapter = BasicAdapter(ArrayList(details?.features))
        recyclerFeatures.layoutManager = LinearLayoutManager(context)
        recyclerFeatures.adapter = featuresAdapter

        textProcedure.text = details?.procedure

        if (details?.sideEffects?.isEmpty() == true) {
            textEmptySideEffects.visibility = View.VISIBLE
        } else {
            textEmptySideEffects.visibility = View.GONE
            val sideEffectsAdapter = BasicAdapter(ArrayList(details?.sideEffects))
            recyclerSideEffects.layoutManager = LinearLayoutManager(context)
            recyclerSideEffects.adapter = sideEffectsAdapter
        }

        val alarmAdapter = BasicAdapter(ArrayList(details?.alarm))
        recyclerAlarm.layoutManager = LinearLayoutManager(context)
        recyclerAlarm.adapter = alarmAdapter

    }

    override fun showParams(params: Params) {
        textFeatures.text = params.feature
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDetach()
    }

}