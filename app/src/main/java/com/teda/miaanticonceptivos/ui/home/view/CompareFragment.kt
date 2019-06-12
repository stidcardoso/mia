package com.teda.miaanticonceptivos.ui.home.view

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.teda.miaanticonceptivos.R
import com.teda.miaanticonceptivos.ui.MainCallback
import com.teda.miaanticonceptivos.ui.home.view.adapter.CompareAdapter
import com.teda.miaanticonceptivos.util.Storage
import kotlinx.android.synthetic.main.fragment_compare.*
import kotlinx.android.synthetic.main.fragment_compares.*

class CompareFragment : Fragment() {

    lateinit var mainCallback: MainCallback
    var compare = false

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is MainCallback)
            mainCallback = context
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.item_compare_method, container, false)
        return v
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        drawer.setOnClickListener {
            mainCallback.openDrawer()
        }
        imageCompare.setOnClickListener {
            compare = !compare
            if (compare)
                imageCompare.setImageResource(R.drawable.compare_selected)
            else
                imageCompare.setImageResource(R.drawable.compare)
        }
        showMethods()
    }

    private fun showMethods() {
        val adapter = CompareAdapter(Storage.methods)
        recyclerMethods.layoutManager = GridLayoutManager(context, Storage.methods.size)
        recyclerMethods.adapter = adapter
    }

    private fun showFaces() {

    }

}