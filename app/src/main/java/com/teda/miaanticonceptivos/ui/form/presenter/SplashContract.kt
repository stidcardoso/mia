package com.teda.miaanticonceptivos.ui.form.presenter

import com.teda.miaanticonceptivos.util.BasePresenter

interface SplashContract {

    interface View {

        fun goToNextActivity()

        fun loadNormalSplash()

    }

    interface Presenter : BasePresenter<View> {

        fun getFirebaseData()

    }

}