package com.teda.miaanticonceptivos.data.model

import io.realm.RealmObject

open class Image: RealmObject() {
    var discreet: String = ""
    var main: String = ""
    var priority: String = ""
    var timing: String = ""
    var welcome: String = ""
}