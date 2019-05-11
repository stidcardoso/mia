package com.teda.miaanticonceptivos.data.local

import com.teda.miaanticonceptivos.data.model.Method
import com.teda.miaanticonceptivos.data.model.Params
import io.realm.Realm

class RealmDao() {

//    val realm = Realm.getDefaultInstance()

//    fun closeRealm() {
//        realm.close()
//    }

    fun insertParams(params: Params) {
        val realm = Realm.getDefaultInstance()
        realm.executeTransaction {
            realm.insertOrUpdate(params)
        }
        realm.close()
    }

    fun insertMethods(methods: ArrayList<Method>) {
        val realm = Realm.getDefaultInstance()
        realm.executeTransaction {
            realm.insertOrUpdate(methods)
        }
        realm.close()
        }

}