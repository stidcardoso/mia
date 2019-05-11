package com.teda.miaanticonceptivos.data.model

import io.realm.RealmObject

open class Price() : RealmObject() {

    var month: String? = ""
    var threeMonths: String? = ""
    var year: String? = ""
    var threeYears: String? = ""
    var fiveYears: String? = ""
    var tenYears: String? = ""

}