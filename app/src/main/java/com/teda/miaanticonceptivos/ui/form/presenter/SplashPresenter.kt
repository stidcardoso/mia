package com.teda.miaanticonceptivos.ui.form.presenter

import android.text.format.DateUtils
import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import com.google.gson.Gson
import com.teda.miaanticonceptivos.data.FbConstants
import com.teda.miaanticonceptivos.data.local.RealmDao
import com.teda.miaanticonceptivos.data.model.*
import com.teda.miaanticonceptivos.util.Storage
import java.util.*
import kotlin.collections.ArrayList

class SplashPresenter(var v: SplashContract.View?) : SplashContract.Presenter {

    override fun onDetach() {
        v = null
        realmDao.closeRealm()
    }

    private val realmDao = RealmDao()
    private var firebase = FirebaseFirestore.getInstance()
    private val gson = Gson()
    private val MAX_SERVICES = 4
    private var countResults = 0

    override fun getFirebaseData() {
        val sDate = realmDao.getSync().dateUpdate?.time ?: 0
        if (DateUtils.isToday(sDate)) {
            v?.loadNormalSplash()
            return
        }

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
                        method?.details?.id = UUID.randomUUID().toString()
                        val position = (method?.id ?: 1) - 1
                        method?.icon = Storage.methods[position].icon
                        method?.let { methods.add(it) }
                    }
                    realmDao.insertMethods(methods)
                    onEndService()
                    val sync = Sync(Date())
                    realmDao.insertSync(sync)
                }
                .addOnFailureListener {
                    Log.d("FirebaseError", it.message)
                    onEndService()
                }

        firebase.collection(FbConstants.PREVENTION)
                .get()
                .addOnCompleteListener {
                    val preventions = ArrayList<Prevention>()
                    if (it.isSuccessful) {
                        for (qPrevention in it.result?.documents ?: arrayListOf()) {
                            val prevention = qPrevention.toObject(Prevention::class.java)
                            preventions.add(prevention ?: Prevention())
                        }
                    }
                    realmDao.insertPreventions(preventions)
                    onEndService()
                }
                .addOnFailureListener {
                    Log.d("FirebaseError", it.message)
                    onEndService()
                }

        firebase.collection(FbConstants.IMAGE)
                .get()
                .addOnCompleteListener { result ->
                    if (result.isSuccessful) {
                        val image = result.result?.documents?.first()?.toObject(Image::class.java)
                        Log.d("Image", image.toString())
                        image?.let { realmDao.insertImage(it) }
                    }
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