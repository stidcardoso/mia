package com.teda.miaanticonceptivos.util

import com.teda.miaanticonceptivos.R
import com.teda.miaanticonceptivos.data.model.Method
import com.teda.miaanticonceptivos.data.model.Priority

object Storage {

    var priorities = arrayListOf<Priority>(
            Priority(0, R.drawable.ic_travel, "Viajar"),
            Priority(1, R.drawable.ic_study, "Estudiar"),
            Priority(2, R.drawable.ic_work, "Trabajar"),
            Priority(3, R.drawable.ic_son, "Tener hijos"),
            Priority(4, R.drawable.ic_time, "Tiempo libre"),
            Priority(5, R.drawable.ic_add_person, "Pareja estable")
    )

    var methods = arrayListOf(
            Method(1, "Ligadura", 1000, 2, R.drawable.ligadura_res),
            Method(2, "Vasectomia", 1000, 2, R.drawable.vasectomia_res),
            Method(3, "T de cobre", 36, 2, R.drawable.cobre_res),
            Method(4, "T de hormonas", 36, 2, R.drawable.hormonas_res),
            Method(5, "Implante", 36, 1, R.drawable.implante),
            Method(6, "Inyectables", 1, 1, R.drawable.inyectables_res),
            Method(7, "Orales", 0, 1, R.drawable.orales_res),
            Method(8, "Parche", 1, 1, R.drawable.parche_res),
            Method(9, "Anillo", 1, 1, R.drawable.anillo_res)
    )

    var compareList = arrayListOf(
            arrayListOf(3,3,3,3,3,2,2,2,2,1),
            arrayListOf(3,3,2,2,2,2,2,2,2,3),
            arrayListOf(3,0,2,3,2,1,1,1,2,3),
            arrayListOf(0,0,2,0,3,2,2,2,2,0),
            arrayListOf(0,0,2,0,3,2,2,2,3,0),
            arrayListOf(3,0,3,3,3,2,2,2,3,0),
            arrayListOf(0,0,0,0,0,0,0,0,0,3),
            arrayListOf(3,3,3,3,3,1,1,1,1,1),
            arrayListOf(3,3,3,3,3,1,1,1,1,1),
            arrayListOf(3,3,2,3,3,2,1,1,3,1)

    )

    var imagesNames = arrayListOf(
            "welcome",
            "priority",
            "discreet",
            "timing",
            "main"
    )

    var selectedPriorities = arrayListOf<Priority?>()
    var sonSelected = false
    var discreetSelected = -1
    var selectedTime = 0

}