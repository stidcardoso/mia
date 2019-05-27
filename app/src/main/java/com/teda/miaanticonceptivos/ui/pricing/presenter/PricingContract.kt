package com.teda.miaanticonceptivos.ui.pricing.presenter

import com.teda.miaanticonceptivos.data.model.Method
import com.teda.miaanticonceptivos.util.BasePresenter

interface PricingContract {

    interface View {

        fun showMethods(methods: ArrayList<Method>)

    }

    interface Presenter : BasePresenter<View> {

        fun getMethodResult()

    }

}