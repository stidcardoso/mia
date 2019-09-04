package com.teda.miaanticonceptivos.data.model

import io.realm.RealmObject

open class Prevention() : RealmObject() {
    var content: String = ""
    constructor(content: String) : this() {
        this.content = content
    }
}