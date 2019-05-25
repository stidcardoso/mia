package com.teda.miaanticonceptivos.ui.methods.view

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.teda.miaanticonceptivos.R

class BasicAdapter(private val list: ArrayList<String>, private val showBullet: Boolean = true) : RecyclerView.Adapter<BasicItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BasicItemViewHolder {
        return if (showBullet)
            getView(parent, R.layout.item_basic_view_bullet)
        else
            getView(parent, R.layout.item_basic_view)
    }

    override fun onBindViewHolder(holder: BasicItemViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

    private fun getView(parent: ViewGroup, layout: Int):BasicItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(layout, parent, false)
        return BasicItemViewHolder(view)
    }

}