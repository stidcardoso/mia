package com.teda.miaanticonceptivos.ui.home.presenter

import com.teda.miaanticonceptivos.data.local.RealmDao

class PreventPresenter(var v: PreventContract.View?) : PreventContract.Presenter {

    private var realmDao = RealmDao()

    override fun onDetach() {
        v = null
        realmDao.closeRealm()
    }

    override fun getPrevents() {
        v?.showPrevents(realmDao.getPreventions())
    }

}