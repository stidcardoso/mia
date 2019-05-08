package com.teda.miaanticonceptivos.ui

import android.support.v4.app.Fragment

interface MainCallback {

    fun openDrawer()

    fun goDetail(fragment: Fragment)

}