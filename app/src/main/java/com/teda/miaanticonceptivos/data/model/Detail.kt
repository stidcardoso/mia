package com.teda.miaanticonceptivos.data.model

import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class Detail : RealmObject() {
    @PrimaryKey
    var id: String? = null
    var features: RealmList<String>? = null
    var recomendations: RealmList<String>? = null
    var procedure: String? = null
    var sideEffects: RealmList<String>? = null
    var alarm: RealmList<String>? = null

}