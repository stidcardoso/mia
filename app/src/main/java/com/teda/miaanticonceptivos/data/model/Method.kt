package com.teda.miaanticonceptivos.data.model

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class Method() : RealmObject() {
    @PrimaryKey
    var id: Int? = null
    var name: String? = null
    var duration: Int? = null
    var discreet: Int? = null
    var icon: Int? = null
    var detailsJson: String? = null
    var month: String? = null
    var threeMonths: String? = null
    var year: String? = null
    var threeYears: String? = null
    var fiveYears: String? = null
    var tenYears: String? = null
    var details: Detail? = null

    constructor(id: Int?, name: String?, duration: Int?, discreet: Int?, icon: Int?) : this() {
        this.id = id
        this.name = name
        this.duration = duration
        this.discreet = discreet
        this.icon = icon
    }
}