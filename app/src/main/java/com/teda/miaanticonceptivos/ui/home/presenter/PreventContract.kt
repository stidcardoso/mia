package com.teda.miaanticonceptivos.ui.home.presenter

import com.teda.miaanticonceptivos.data.model.Prevention
import com.teda.miaanticonceptivos.util.BasePresenter

interface PreventContract {

    interface View {

        fun showPrevents(prevents: ArrayList<Prevention>)

    }

    interface Presenter : BasePresenter<View> {

        fun getPrevents()

    }

}