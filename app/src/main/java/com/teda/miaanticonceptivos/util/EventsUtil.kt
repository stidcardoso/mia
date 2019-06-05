package com.teda.miaanticonceptivos.util

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
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

    fun setMethodResult() {
        val bundle = Bundle()
        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, START_QUESTIONS)
        bundle.putString()
        firebaseAnalytics.logEvent(METHOD_RESULT, bundle)
    }

    fun setCurrentScreen(activity: AppCompatActivity, fragment: Fragment) {
        firebaseAnalytics.setCurrentScreen(activity, fragment::class.java.simpleName, fragment::class.java.simpleName)
    }

    companion object {
        const val END_QUESTIONS = "terminar_preguntas"
        const val START_QUESTIONS = "iniciar_preguntas"
        const val METHOD_RESULT = "resultado_metodos"
    }
}