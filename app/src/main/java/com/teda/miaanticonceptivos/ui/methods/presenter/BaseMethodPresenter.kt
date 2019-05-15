package com.teda.miaanticonceptivos.ui.methods.presenter

import com.teda.miaanticonceptivos.data.local.RealmDao

class BaseMethodPresenter(var v: BaseMethodContract.View?) : BaseMethodContract.Presenter {

    override fun onDetach() {
        v = null
        realmDao?.closeRealm()
    }

    private var realmDao: RealmDao? = RealmDao()

    override fun getMethod(name: String) {
        realmDao?.getMethodByName(name)?.let { v?.showMethod(it) }
    }

}