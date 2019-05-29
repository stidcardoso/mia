package com.teda.miaanticonceptivos.ui.home.presenter

import com.teda.miaanticonceptivos.data.model.MethodResult
import com.teda.miaanticonceptivos.util.BasePresenter

interface HomeContract {

    interface View {

        fun showImage(url: String)

    }

    interface Presenter: BasePresenter<View> {

        fun saveMethodResults(methodResults: ArrayList<MethodResult>)

        fun getImage()

    }

}