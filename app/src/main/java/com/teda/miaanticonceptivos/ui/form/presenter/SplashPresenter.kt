package com.teda.miaanticonceptivos.ui.form.presenter

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.text.format.DateUtils
import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import com.squareup.picasso.Target
import com.teda.miaanticonceptivos.App
import com.teda.miaanticonceptivos.data.FbConstants
import com.teda.miaanticonceptivos.data.local.RealmDao
import com.teda.miaanticonceptivos.data.model.*
import com.teda.miaanticonceptivos.util.Storage
import java.io.File
import java.io.FileOutputStream
import java.util.*
import kotlin.collections.ArrayList

class SplashPresenter(var v: SplashContract.View?) : SplashContract.Presenter {

    override fun onDetach() {
        v = null
        realmDao.closeRealm()
    }

    private val targets = ArrayList<Target>()
    private val realmDao = RealmDao()
    private var firebase = FirebaseFirestore.getInstance()
    private val gson = Gson()
    private val MAX_SERVICES = 4
    private var countResults = 0
    private var imagesSaved = 0
    private var imagesSize = 0

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

       /* firebase.collection(FbConstants.PREVENTION)
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
                }*/

        firebase.collection(FbConstants.IMAGE)
                .get()
                .addOnCompleteListener { result ->
                    if (result.isSuccessful) {
                        val images = ArrayList<Image>()
                        for (img in result.result?.documents ?: arrayListOf()) {
                            val image = img.toObject(Image::class.java)
                            image?.let { images.add(it) }
                        }
//                        image?.let { realmDao.insertImage(it) }
                        saveImages(images)
                        realmDao.insertImages(images)
                    } else {
                        onEndService()
                    }
                }
                .addOnFailureListener {
                    Log.d("FirebaseError", it.message)
                    onEndService()
                }
    }

    private fun getTarget(name: String): Target {
        return object : Target {
            override fun onPrepareLoad(placeHolderDrawable: Drawable?) {
            }

            override fun onBitmapFailed(e: Exception?, errorDrawable: Drawable?) {
                imagesSaved += 1
                endImageService()
            }

            override fun onBitmapLoaded(bitmap: Bitmap?, from: Picasso.LoadedFrom?) {
                Log.d("ImageLoaded", "ImagedLoaded")
                val file = File(App.app!!.applicationContext.filesDir, name)
                if (file.exists()) {
                    file.delete()
                }
                try {
                    val out = FileOutputStream(file)
                    bitmap?.compress(Bitmap.CompressFormat.PNG, 100, out)
                    out.flush()
                    out.close()
                } catch (e: java.lang.Exception) {
                }
                imagesSaved += 1
                endImageService()
            }
        }
    }

    private fun endImageService() {
        if (imagesSaved >= imagesSize)
            onEndService()
    }

    private fun saveImages(images: ArrayList<Image>) {
        imagesSaved = images.size
        for (image in images) {
            val target = getTarget(image.name + ".png")
            targets.add(target)
            Picasso.get()
                    .load(image.image)
                    .into(target)
        }
    }

    private fun onEndService() {
        countResults = countResults.inc()
        if (countResults == MAX_SERVICES)
            v?.goToNextActivity()
    }

}