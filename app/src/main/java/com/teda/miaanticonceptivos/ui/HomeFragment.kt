package com.teda.miaanticonceptivos.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.firebase.database.FirebaseDatabase
import com.teda.miaanticonceptivos.R
import com.teda.miaanticonceptivos.util.Storage
import com.teda.miaanticonceptivos.util.Utilities
import com.teda.miaanticonceptivos.ui.fragment.*
import com.teda.miaanticonceptivos.data.model.Method
import com.teda.miaanticonceptivos.data.model.TimeAnalytics
import kotlinx.android.synthetic.main.activity_home.*
import java.util.*

class HomeFragment : Fragment() {

    lateinit var mainCallback: MainCallback

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.activity_home, container, false)
        return v
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

    fun getResults() {
        var methods = Storage.methods.toList()
        var filteredMethods: List<Method>
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
            return
        }
//        methods.shuffled()
        result.add(methods.first())
        methods = methods.sortedWith(object : Comparator<Method> {
            override fun compare(m1: Method?, m2: Method?): Int = when {
                Math.abs(m1!!.duration - Storage.selectedTime) > Math.abs(m2!!.duration - Storage.selectedTime) -> 1
                Math.abs(m1!!.duration - Storage.selectedTime) == Math.abs(m2!!.duration - Storage.selectedTime) -> 0
                else -> -1
            }

        })
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
        showResult(ArrayList(methods))


//        textView9.text = result.first().name + result[1].name
    }

    fun showResult(result: ArrayList<Method>) {
        text1.text = result.first().name
        imageRes1.setImageDrawable(ContextCompat.getDrawable(context!!, result.first().icon))
        text2.text = result[1].name
        imageRes2.setImageDrawable(ContextCompat.getDrawable(context!!, result[1].icon))

        imageRes1.setOnClickListener {
            changeFragment(result.first().id)
        }

        imageRes2.setOnClickListener {
            changeFragment(result[1].id)
        }

        if (result.size > 2) {
            text3.text = result[2].name
            imageRes3.setImageDrawable(ContextCompat.getDrawable(context!!, result[2].icon))
            imageRes3.setOnClickListener {
                if (result.size > 2)
                    changeFragment(result[2].id)
            }
        }
    }

    fun changeFragment(id: Int) {
        var fragment = when (id) {
            0 -> LigaduraFragment()
            1 -> VasectomiaFragment()
            2 -> CobreFragment()
            3 -> HormonasFragment()
            4 -> ImplanteFragment()
            5 -> InyectablesFragment()
            6 -> OralesFragment()
            7 -> ParcheFragment()
            8 -> AnilloFragment()
            else -> LigaduraFragment()
        }
        mainCallback.goDetail(fragment)
    }

}