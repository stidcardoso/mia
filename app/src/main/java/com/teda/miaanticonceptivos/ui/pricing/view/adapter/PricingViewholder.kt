package com.teda.miaanticonceptivos.ui.pricing.view.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import com.teda.miaanticonceptivos.data.model.Method
import kotlinx.android.synthetic.main.item_pricing.view.*

class PricingViewholder(itemView: View): RecyclerView.ViewHolder(itemView) {

    fun bind(methods: ArrayList<Method>) {
        itemView.textPrice1.text = methods[0].getPrices()[adapterPosition]
        itemView.textPrice2.text = methods[1].getPrices()[adapterPosition]
    }

}