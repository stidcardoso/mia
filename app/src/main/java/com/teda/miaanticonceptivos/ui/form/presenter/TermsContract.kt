package com.teda.miaanticonceptivos.ui.form.presenter

import com.teda.miaanticonceptivos.util.BasePresenter

interface TermsContract {

    interface View {

        fun showTerms(terms: String)

    }

    interface Presenter : BasePresenter<View> {

        fun getTerms()

    }

}