package com.teda.miaanticonceptivos.ui.pricing.view.adapter

import android.graphics.Color
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.View
import com.teda.miaanticonceptivos.R
import com.teda.miaanticonceptivos.data.model.Method
import com.teda.miaanticonceptivos.util.Utilities
import kotlinx.android.synthetic.main.item_pricing.view.*

class PricingViewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val pricesTitle = itemView.resources.getStringArray(R.array.prices_titles)

    fun bind(methods: ArrayList<Method>, selectedPosition: Int?) {
        itemView.textTime.text = pricesTitle[adapterPosition]
        itemView.textPrice1.text = Utilities.getCurrency(methods[0].getPrices()[adapterPosition]
                ?: "")
        itemView.textPrice2.text = Utilities.getCurrency(methods[1].getPrices()[adapterPosition]
                ?: "")
        if (methods.size > 2) {
            itemView.textPrice3.text = Utilities.getCurrency(methods[2].getPrices()[adapterPosition]
                    ?: "")
        }
        if (adapterPosition == selectedPosition)
            itemView.setBackgroundColor(ContextCompat.getColor(itemView.context, R.color.orange))
        else
            itemView.setBackgroundColor(Color.TRANSPARENT)
    }

}