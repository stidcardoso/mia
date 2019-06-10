package com.teda.miaanticonceptivos.ui.pricing.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.teda.miaanticonceptivos.R
import com.teda.miaanticonceptivos.data.model.Method
import com.teda.miaanticonceptivos.ui.pricing.presenter.PricingContract
import com.teda.miaanticonceptivos.ui.pricing.presenter.PricingPresenter
import com.teda.miaanticonceptivos.ui.pricing.view.adapter.PricingAdapter
import com.teda.miaanticonceptivos.util.Utilities
import kotlinx.android.synthetic.main.fragment_pricing.*

class PricingActivity : AppCompatActivity(), PricingContract.View {

    val adapter: PricingAdapter? = null
    private val presenter = PricingPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_pricing)
        presenter.getMethodResult()

        btnClose.setOnClickListener {
            finish()
        }
    }

    override fun showMethods(methods: ArrayList<Method>) {
        if (methods.isEmpty())
            return
        methods[0].icon?.let { imageRes1.setImageResource(it) }
        methods[1].icon?.let { imageRes2.setImageResource(it) }
        textMethod1.text = methods[0].name
        textMethod2.text = methods[1].name
        textPrice1.text = Utilities.getCurrency(methods[0].price ?: "")
        textPrice2.text = Utilities.getCurrency(methods[1].price ?: "")
        if(methods.size > 2) {
            methods[2].icon?.let { imageRes3.setImageResource(it) }
            textMethod3.text = methods[2].name
            textPrice3.text = Utilities.getCurrency(methods[2].price ?: "")
        }
        val adapter = PricingAdapter(methods)
        recyclerPricing.layoutManager = LinearLayoutManager(this)
        recyclerPricing.adapter = adapter
    }

/*
    private fun showPrices() {

    }
*/

}