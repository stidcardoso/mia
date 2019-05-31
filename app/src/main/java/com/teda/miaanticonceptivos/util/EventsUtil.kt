package com.teda.miaanticonceptivos.util

import android.os.Bundle
import com.google.firebase.analytics.FirebaseAnalytics

class EventsUtil(private var firebaseAnalytics: FirebaseAnalytics) {

    fun endQuestions() {
        val bundle = Bundle()
        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, END_QUESTIONS)
        firebaseAnalytics.logEvent(END_QUESTIONS, bundle)
    }

    fun newSession() {
        val bundle = Bundle()
        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, START_QUESTIONS)
        firebaseAnalytics.logEvent(START_QUESTIONS, bundle)
    }


    companion object {
        const val END_QUESTIONS = "terminar_preguntas"
        const val START_QUESTIONS = "iniciar_preguntas"
    }
}