package com.teda.miaanticonceptivos.data.model

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class MethodResult() : RealmObject() {

    @PrimaryKey
    var id: Int? = null

    constructor(id: Int) : this() {
        this.id = id
    }

}