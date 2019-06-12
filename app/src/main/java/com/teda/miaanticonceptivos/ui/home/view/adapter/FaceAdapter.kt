package com.teda.miaanticonceptivos.ui.home.view.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.teda.miaanticonceptivos.R

class FaceAdapter(private val list: ArrayList<ArrayList<Int>>) : RecyclerView.Adapter<FaceViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FaceViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_basic_view, parent, false)
        return FaceViewHolder(view)
    }

    override fun onBindViewHolder(holder: FaceViewHolder, position: Int) {
    }

    override fun getItemCount(): Int = list.size


}