package com.teda.miaanticonceptivos.ui.form.presenter

import com.teda.miaanticonceptivos.data.local.RealmDao

class TermsPresenter(var v: TermsContract.View?) : TermsContract.Presenter {

    override fun onDetach() {
        v = null
        realmDao.closeRealm()
    }

    private val realmDao = RealmDao()

    override fun getTerms() {
        v?.showTerms(realmDao.getParams().terms)
    }


}