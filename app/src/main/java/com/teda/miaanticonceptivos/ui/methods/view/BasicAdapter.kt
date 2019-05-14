package com.teda.miaanticonceptivos.ui.methods.view

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.teda.miaanticonceptivos.R

class BasicAdapter(private val list: ArrayList<String>) : RecyclerView.Adapter<BasicItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BasicItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_basic_view, parent, false)
        return BasicItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: BasicItemViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

}