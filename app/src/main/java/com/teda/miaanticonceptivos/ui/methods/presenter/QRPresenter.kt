package com.teda.miaanticonceptivos.ui.methods.presenter

import com.teda.miaanticonceptivos.data.local.RealmDao

class QRPresenter(var v: QRContract.View?) : QRContract.Presenter {

    override fun onDetach() {
        v = null
        realmDao?.closeRealm()
    }

    private var realmDao: RealmDao? = RealmDao()

    override fun getParams() {
        realmDao?.getParams()?.let { v?.showQR(it.webUrl) }
    }

}