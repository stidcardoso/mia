package com.teda.miaanticonceptivos.ui.home.view.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.teda.miaanticonceptivos.R
import com.teda.miaanticonceptivos.data.model.Prevention

class PreventionAdapter(private val list: ArrayList<Prevention>) : RecyclerView.Adapter<PreventViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PreventViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_basic_view, parent, false)
        return PreventViewHolder(view)
    }

    override fun onBindViewHolder(holder: PreventViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size


}