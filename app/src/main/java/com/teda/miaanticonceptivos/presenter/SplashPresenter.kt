package com.teda.miaanticonceptivos.presenter

import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import com.google.gson.Gson
import com.teda.miaanticonceptivos.data.FbConstants
import com.teda.miaanticonceptivos.data.local.RealmDao
import com.teda.miaanticonceptivos.data.model.Method
import com.teda.miaanticonceptivos.data.model.Params

class SplashPresenter(var v: SplashContract.View?) : SplashContract.Presenter {

    override fun onDetach() {
        v = null
    }

    private val realmDao = RealmDao()
    private var firebase = FirebaseFirestore.getInstance()
    private val gson = Gson()
    private val MAX_SERVICES = 2
        private var countResults = 0

    override fun getFirebaseData() {
        firebase.collection(FbConstants.PARAMS)
                .get()
                .addOnCompleteListener { result ->
                    when {
                        result.isSuccessful -> {
                            val params = result.result?.documents?.first()?.toObject(Params::class.java)
                            Log.d("PARAMS", params?.terms)
                            params?.let { realmDao.insertParams(it) }
                        }
                    }
                    onEndService()
                }.addOnFailureListener {
                    Log.d("FirebaseError", it.message)
                    onEndService()
                }

        firebase.collection(FbConstants.METHOD)
                .get()
                .addOnCompleteListener { result ->
                    val methods = ArrayList<Method>()
                    for (qMethod in result.result?.documents ?: arrayListOf()) {
                        val method = qMethod.toObject(Method::class.java)
                        method?.details = gson.fromJson(method?.detailsJson, Method::class.java).details
                        method?.let { methods.add(it) }
                    }
                    realmDao.insertMethods(methods)
                    onEndService()
                }
                .addOnFailureListener {
                    Log.d("FirebaseError", it.message)
                    onEndService()
                }
    }

    private fun onEndService() {
        countResults = countResults.inc()
        if (countResults == MAX_SERVICES)
            v?.goToNextActivity()
    }

}