package com.teda.miaanticonceptivos.ui.methods.presenter

import com.teda.miaanticonceptivos.data.model.Method
import com.teda.miaanticonceptivos.util.BasePresenter

interface BaseMethodContract {

    interface View {

        fun showMethod(method: Method)

    }

    interface Presenter : BasePresenter<View> {

        fun getMethod(name: String)

    }

}