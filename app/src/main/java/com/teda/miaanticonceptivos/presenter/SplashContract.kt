package com.teda.miaanticonceptivos.presenter

import com.teda.miaanticonceptivos.util.BasePresenter

interface SplashContract {

    interface View {

        fun goToNextActivity()

    }

    interface Presenter : BasePresenter<View> {

        fun getFirebaseData()

    }

}