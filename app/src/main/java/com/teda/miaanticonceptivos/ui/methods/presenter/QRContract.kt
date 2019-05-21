package com.teda.miaanticonceptivos.ui.methods.presenter

import com.teda.miaanticonceptivos.data.model.Method
import com.teda.miaanticonceptivos.util.BasePresenter

interface QRContract {

    interface View {

        fun showQR(url: String)

    }

    interface Presenter : BasePresenter<View> {

        fun getParams()

    }

}