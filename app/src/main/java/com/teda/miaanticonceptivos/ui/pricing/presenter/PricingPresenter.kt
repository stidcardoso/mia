package com.teda.miaanticonceptivos.ui.pricing.presenter

import com.teda.miaanticonceptivos.data.local.RealmDao

class PricingPresenter(var v: PricingContract.View?) : PricingContract.Presenter {

    private var realmDao = RealmDao()

    override fun onDetach() {
        v = null
        realmDao.closeRealm()
    }

    override fun getMethodResult() {
        v?.showMethods(ArrayList(realmDao.getMethodsFromResult()))
    }

}