package com.teda.miaanticonceptivos.ui.home.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.google.firebase.database.FirebaseDatabase
import com.teda.miaanticonceptivos.R
import com.teda.miaanticonceptivos.data.model.Method
import com.teda.miaanticonceptivos.data.model.MethodResult
import com.teda.miaanticonceptivos.data.model.TimeAnalytics
import com.teda.miaanticonceptivos.ui.MainCallback
import com.teda.miaanticonceptivos.ui.form.view.TutorialActivity
import com.teda.miaanticonceptivos.ui.home.presenter.HomeContract
import com.teda.miaanticonceptivos.ui.home.presenter.HomePresenter
import com.teda.miaanticonceptivos.ui.methods.view.fragment.*
import com.teda.miaanticonceptivos.util.Storage
import com.teda.miaanticonceptivos.util.Utilities
import kotlinx.android.synthetic.main.activity_home.*
import java.util.*
import kotlin.collections.ArrayList

class HomeFragment : Fragment(), HomeContract.View {

    lateinit var mainCallback: MainCallback
    private val presenter = HomePresenter(this)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.activity_home, container, false)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is MainCallback)
            mainCallback = context
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getResults()
        home.setOnClickListener {
            mainCallback.openDrawer()
        }
        btnRestart.setOnClickListener {
            val time = TimeAnalytics()
            time.duration = Utilities.endTime()
            time.id = UUID.randomUUID().toString()
            val firebase = FirebaseDatabase.getInstance().getReference("time")
            firebase.child(time.id).setValue(time)
            val i = Intent(activity, TutorialActivity::class.java)
            startActivity(i)
            activity?.finishAffinity()
        }
    }

    private fun getResults() {
        var methods = Storage.methods.toList()
//        var filteredMethods: List<Method>
        val result = arrayListOf<Method>()
        if (Storage.sonSelected)
            methods = methods.filter {
                it.duration != 1000
            }
        if (Storage.discreetSelected == 2) {
            methods = methods.filter {
                it.discreet == Storage.discreetSelected
            }
        }
        if (methods.size <= 2) {
            showResult(ArrayList(methods))
            saveResults(ArrayList(methods))
            return
        }
//        methods.shuffled()
        result.add(methods.first())
        methods = methods.sortedWith(object : Comparator<Method> {
            override fun compare(m1: Method?, m2: Method?): Int = when {
                Math.abs(m1!!.duration ?: 0 - Storage.selectedTime) > Math.abs(m2!!.duration ?: 0
                - Storage.selectedTime) -> 1
                Math.abs(m1.duration ?: 0 - Storage.selectedTime) == Math.abs(m2!!.duration ?: 0
                - Storage.selectedTime) -> 0
                else -> -1
            }

        })
        showResult(ArrayList(methods))
        saveResults(ArrayList(methods))
        /* for (method in methods) {
             val near = Math.abs(method.duration - Storage.selectedTime)
             if (result.isNotEmpty()) {
                 val current = Math.abs(result.first().duration - Storage.selectedTime)
                 if (near <= current)
                     result.add(0, method)
                 else
                     result.add(method)
             } else
                 result.add(method)
         }*/

//        textView9.text = result.first().name + result[1].name
    }

    private fun saveResults(mMethods: ArrayList<Method>) {
        var i = 0
        val methodResults = ArrayList<MethodResult>()
        for (method in mMethods) {
            i += 1
            if (i > 3) break
            methodResults.add(MethodResult(method.id ?: 1, i))
        }
        presenter.saveMethodResults(methodResults)
    }

    private fun showResult(result: ArrayList<Method>) {
        text1.text = result.first().name
        imageRes1.setImageDrawable(ContextCompat.getDrawable(context!!, result.first().icon ?: 0))
        text2.text = result[1].name
        imageRes2.setImageDrawable(ContextCompat.getDrawable(context!!, result[1].icon ?: 0))

        imageRes1.setOnClickListener {
            changeFragment(result.first().id ?: 0)
        }

        imageRes2.setOnClickListener {
            changeFragment(result[1].id ?: 0)
        }

        if (result.size > 2) {
            text3.text = result[2].name
            imageRes3.setImageDrawable(ContextCompat.getDrawable(context!!, result[2].icon ?: 0))
            imageRes3.setOnClickListener {
                if (result.size > 2)
                    changeFragment(result[2].id ?: 0)
            }
        }
    }

    private fun changeFragment(id: Int) {
        val fragment: Fragment = when (id) {
            1 -> LigaduraFragment()
            2 -> VasectomiaFragment()
            3 -> CobreFragment()
            4 -> HormonasFragment()
            5 -> ImplanteFragment()
            6 -> InyectablesFragment()
            7 -> OralesFragment()
            8 -> ParcheFragment()
            9 -> AnilloFragment()
            else -> LigaduraFragment()
        }
        mainCallback.goDetail(fragment)
    }

    override fun showImage(url: String) {
        Glide.with(this)
                .load(url)
                .error(ContextCompat.getDrawable(context!!, R.drawable.home_background))
                .into(imageBackground)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDetach()
    }

}