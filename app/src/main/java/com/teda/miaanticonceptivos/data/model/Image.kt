package com.teda.miaanticonceptivos.data.model

import io.realm.RealmObject

open class Image : RealmObject() {
    var discreet: String = ""
    var main: String = ""
    var priority: String = ""
    var timing: String = ""
    var welcome: String = ""

    fun getURLs(): ArrayList<String> {
        val list = ArrayList<String>()
        list.add(discreet)
        list.add(main)
        list.add(priority)
        list.add(timing)
        list.add(welcome)
        return list
    }
}