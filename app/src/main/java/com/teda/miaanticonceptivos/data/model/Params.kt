package com.teda.miaanticonceptivos.data.model

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey


open class Params : RealmObject() {
    @PrimaryKey
    var id = 1
    var terms: String = ""
    var feature: String = ""
    var webUrl: String = ""
}