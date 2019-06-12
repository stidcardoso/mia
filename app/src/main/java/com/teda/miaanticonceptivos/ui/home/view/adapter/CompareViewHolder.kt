package com.teda.miaanticonceptivos.ui.home.view.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import com.teda.miaanticonceptivos.data.model.Method
import kotlinx.android.synthetic.main.item_compare_method.view.*

class CompareViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(method: Method) {
        method.icon?.let { itemView.imageRes.setImageResource(it) }
        itemView.textMethodName.text = method.name
    }

}