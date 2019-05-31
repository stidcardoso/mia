package com.teda.miaanticonceptivos

import android.app.Application
import com.google.firebase.analytics.FirebaseAnalytics
import com.teda.miaanticonceptivos.util.EventsUtil
import io.opencensus.internal.BaseMessageEventUtil
import io.realm.Realm
import io.realm.RealmConfiguration

class App : Application() {


    companion object {
        lateinit var eventUtil: EventsUtil
    }

    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
        val config = RealmConfiguration.Builder().build()
        Realm.setDefaultConfiguration(config)
        val firebaseAnalytics = FirebaseAnalytics.getInstance(this)
        eventUtil = EventsUtil(firebaseAnalytics)
    }


}