package com.teda.miaanticonceptivos.data.local

import com.teda.miaanticonceptivos.data.FbConstants
import com.teda.miaanticonceptivos.data.model.*
import io.realm.Realm

class RealmDao {

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

    fun getMethodByName(name: String): Method {
        return realm.where(Method::class.java).equalTo(FbConstants.NAME, name).findFirst()
                ?: Method()
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

    fun insertMethodResults(methodResults: List<MethodResult>) {
        realm.executeTransaction {
            realm.where(MethodResult::class.java).findAll().deleteAllFromRealm()
            realm.insertOrUpdate(methodResults)
        }
    }

    fun getMethodsFromResult(): List<Method> {
        val methodResults = realm.where(MethodResult::class.java).sort(FbConstants.POSITION).findAll()
        val ids = ArrayList<Int>()
        for (m in methodResults) {
            ids.add(m.id ?: 0)
        }
        val methods = realm.where(Method::class.java).`in`(FbConstants.ID, ids.toTypedArray()).findAll()
        val result = ArrayList<Method>()
        for (id in ids) {
            methods.find { it.id == id }?.let { result.add(it) }
        }
        return result
    }

    fun insertPreventions(preventions: ArrayList<Prevention>) {
        realm.executeTransaction {
            realm.where(Prevention::class.java).findAll().deleteAllFromRealm()
            realm.insertOrUpdate(preventions)
        }
    }

    fun getPreventions(): ArrayList<Prevention> {
        return ArrayList(realm.where(Prevention::class.java).findAll())
    }

    fun insertImage(image: Image) {
        realm.executeTransaction {
            realm.where(Image::class.java).findAll().deleteAllFromRealm()
            realm.insertOrUpdate(image)
        }
    }

    fun getImage(): Image {
        return realm.where(Image::class.java).findFirst() ?: Image()
    }

}