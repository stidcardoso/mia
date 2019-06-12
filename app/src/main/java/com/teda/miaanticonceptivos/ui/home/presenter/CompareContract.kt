package com.teda.miaanticonceptivos.ui.home.presenter

import com.teda.miaanticonceptivos.data.model.Method
import com.teda.miaanticonceptivos.data.model.MethodResult
import com.teda.miaanticonceptivos.util.BasePresenter

interface CompareContract {

    interface View {

        fun showMethods(methods: ArrayList<Method>)

    }

    interface Presenter: BasePresenter<View> {

        fun getMethods()

    }

}