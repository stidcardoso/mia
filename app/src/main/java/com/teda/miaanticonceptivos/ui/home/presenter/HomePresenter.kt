package com.teda.miaanticonceptivos.ui.home.presenter

import com.teda.miaanticonceptivos.data.local.RealmDao
import com.teda.miaanticonceptivos.data.model.MethodResult

class HomePresenter(var v: HomeContract.View?) : HomeContract.Presenter {

    private val realmDao = RealmDao()

    override fun onDetach() {
        v = null
        realmDao.closeRealm()
    }

    override fun saveMethodResults(methodResults: ArrayList<MethodResult>) {
        realmDao.insertMethodResults(methodResults)
    }

    override fun getImage() {
//        v?.showImage(realmDao.getImage().main)
    }

}