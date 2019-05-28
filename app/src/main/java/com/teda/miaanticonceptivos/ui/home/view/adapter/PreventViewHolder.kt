package com.teda.miaanticonceptivos.ui.home.view.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import com.teda.miaanticonceptivos.data.model.Prevention
import kotlinx.android.synthetic.main.item_basic_view.view.*

class PreventViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(prevention: Prevention) {
        itemView.textContent.text = prevention.content
    }

}