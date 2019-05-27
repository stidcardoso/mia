package com.teda.miaanticonceptivos.data.model

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class MethodResult(@PrimaryKey
                        var id: Int = 0) : RealmObject()