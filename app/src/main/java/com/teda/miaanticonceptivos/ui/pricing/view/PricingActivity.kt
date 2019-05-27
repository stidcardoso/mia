package com.teda.miaanticonceptivos.ui.pricing.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.teda.miaanticonceptivos.R
import com.teda.miaanticonceptivos.data.model.Method
import com.teda.miaanticonceptivos.ui.pricing.presenter.PricingContract
import com.teda.miaanticonceptivos.ui.pricing.presenter.PricingPresenter
import com.teda.miaanticonceptivos.ui.pricing.view.adapter.PricingAdapter
import kotlinx.android.synthetic.main.fragment_pricing.*

class PricingActivity : AppCompatActivity(), PricingContract.View {

    val adapter: PricingAdapter? = null
    private val presenter = PricingPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_pricing)
        presenter.getMethodResult()
    }

    override fun showMethods(methods: ArrayList<Method>) {
        if (methods.isEmpty())
            return
        imageRes1.setImageResource(methods[0].icon ?: 0)
        imageRes2.setImageResource(methods[1].icon ?: 0)
        textMethod1.text = methods[0].name
        textMethod2.text = methods[1].name
    }

/*
    private fun showPrices() {
        val adapter = PricingAdapter()
        recyclerPricing.layoutManager = LinearLayoutManager(this)
        recyclerPricing.adapter = adapter
    }
*/

}