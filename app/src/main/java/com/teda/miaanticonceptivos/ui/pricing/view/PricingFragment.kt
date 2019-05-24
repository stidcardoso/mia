package com.teda.miaanticonceptivos.ui.pricing.view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.teda.miaanticonceptivos.R
import com.teda.miaanticonceptivos.ui.pricing.view.adapter.PricingAdapter
import kotlinx.android.synthetic.main.fragment_pricing.*

class PricingFragment : Fragment() {

    val adapter: PricingAdapter? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_pricing, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showPrices()
    }

    private fun showPrices() {
        val adapter = PricingAdapter()
        recyclerPricing.layoutManager = LinearLayoutManager(context)
        recyclerPricing.adapter = adapter
    }

}