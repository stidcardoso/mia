package com.teda.miaanticonceptivos.ui.home.presenter

import com.teda.miaanticonceptivos.data.local.RealmDao
import com.teda.miaanticonceptivos.data.model.MethodResult

class ComparePresenter(var v: CompareContract.View?) : CompareContract.Presenter {

    private val realmDao = RealmDao()

    override fun onDetach() {
        v = null
        realmDao.closeRealm()
    }

    override fun getMethods() {

    }

}