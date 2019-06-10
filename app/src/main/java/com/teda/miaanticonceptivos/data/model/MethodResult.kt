package com.teda.miaanticonceptivos.data.model

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class MethodResult() : RealmObject() {

    @PrimaryKey
    var id: Int? = null
    var position: Int? = null

    constructor(id: Int, position: Int) : this() {
        this.id = id
        this.position = position
    }

}