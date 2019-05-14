package com.teda.miaanticonceptivos.data.local

import com.teda.miaanticonceptivos.data.FbConstants
import com.teda.miaanticonceptivos.data.model.Method
import com.teda.miaanticonceptivos.data.model.Params
import com.teda.miaanticonceptivos.data.model.Sync
import io.realm.Realm

class RealmDao() {

    val realm = Realm.getDefaultInstance()!!

    fun closeRealm() {
        realm.close()
    }

    fun insertParams(params: Params) {
        realm.executeTransaction {
            realm.where(Params::class.java).findAll().deleteAllFromRealm()
            realm.insertOrUpdate(params)
        }
    }

    fun getParams(): Params {
        return realm.where(Params::class.java).findFirst() ?: Params()
    }

    fun insertMethods(methods: ArrayList<Method>) {
        realm.executeTransaction {
            realm.insertOrUpdate(methods)
        }
    }

    fun getMethodByName(name: String):Method {
        return realm.where(Method::class.java).contains(FbConstants.NAME, name).findFirst() ?: Method()
    }

    fun getSync(): Sync {
        return realm.where(Sync::class.java).findFirst() ?: Sync()
    }

    fun insertSync(sync: Sync) {
        realm.executeTransaction {
            realm.where(Sync::class.java).findAll().deleteAllFromRealm()
            realm.insertOrUpdate(sync)
        }
    }

}