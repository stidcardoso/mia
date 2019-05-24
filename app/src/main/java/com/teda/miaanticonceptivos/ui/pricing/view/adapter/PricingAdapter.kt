package com.teda.miaanticonceptivos.ui.pricing.view.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.teda.miaanticonceptivos.R

class PricingAdapter : RecyclerView.Adapter<PricingViewholder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PricingViewholder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_pricing, parent, false)
        return PricingViewholder(v)
    }

    override fun onBindViewHolder(holder: PricingViewholder, position: Int) {

    }

    override fun getItemCount(): Int = 6
}