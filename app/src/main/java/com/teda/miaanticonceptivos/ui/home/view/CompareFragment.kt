package com.teda.miaanticonceptivos.ui.home.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.teda.miaanticonceptivos.R
import com.teda.miaanticonceptivos.data.model.Method
import com.teda.miaanticonceptivos.ui.MainCallback
import com.teda.miaanticonceptivos.ui.home.DrawerHelper
import com.teda.miaanticonceptivos.ui.home.view.adapter.CompareAdapter
import com.teda.miaanticonceptivos.ui.home.view.adapter.FaceAdapter
import com.teda.miaanticonceptivos.ui.pricing.view.PricingActivity
import com.teda.miaanticonceptivos.util.Storage
import com.teda.miaanticonceptivos.util.Utilities
import kotlinx.android.synthetic.main.component_side_bar.*
import kotlinx.android.synthetic.main.fragment_compares.*

class CompareFragment : Fragment() {

    lateinit var mainCallback: MainCallback
    var compare = false
    lateinit var compareAdapter: CompareAdapter
    lateinit var faceAdapter: FaceAdapter

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is MainCallback)
            mainCallback = context
    }

    private val featuresList by lazy { arrayListOf<TextView>(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10) }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_compares, container, false)
        return v
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        imageLight.visibility = View.GONE
        DrawerHelper(sideBar, this)
        drawer.setOnClickListener {
            mainCallback.openDrawer()
        }
        imageCompare.setOnClickListener {
            startActivity(Intent(context, PricingActivity::class.java))

            /* compare = !compare
             if (compare)
                 imageCompare.setImageResource(R.drawable.compare_selected)
             else
                 imageCompare.setImageResource(R.drawable.compare)*/
        }
        showMethods()
        showFaces()
        for (i in 0 until featuresList.size)
            featuresList[i].setOnClickListener { faceAdapter.setSelectedPosition(i) }
    }

    private fun showMethods() {
        val methods = ArrayList(Storage.methods)
        methods.add(Method(10, "CONDÓN", 1, 1, R.drawable.condon_res))
        val listener = object : CompareAdapter.Callback {
            override fun onItemClicked(position: Int) {
                mainCallback.goDetail(Utilities.getFragmentMethod(position))
            }
        }
        compareAdapter = CompareAdapter(methods, listener)
        recyclerMethods.layoutManager = GridLayoutManager(context, methods.size)
        recyclerMethods.adapter = compareAdapter
    }

    private fun showFaces() {
        faceAdapter = FaceAdapter(Storage.compareList)
        recyclerFaces.layoutManager = GridLayoutManager(context, Storage.compareList[0].size)
        recyclerFaces.adapter = faceAdapter
    }

}