package com.teda.miaanticonceptivos.ui.methods.view

import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.item_basic_view.view.*

class BasicItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(text: String) {
        itemView.textContent.text = text
    }

}