package com.teda.miaanticonceptivos.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.teda.miaanticonceptivos.App
import com.teda.miaanticonceptivos.R
import com.teda.miaanticonceptivos.ui.home.EmergencyFragment
import com.teda.miaanticonceptivos.ui.home.view.CompareFragment
import com.teda.miaanticonceptivos.ui.home.view.HomeFragment
import com.teda.miaanticonceptivos.ui.home.view.PreventFragment
import com.teda.miaanticonceptivos.ui.methods.view.fragment.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainCallback {

    private var currentFragment: Fragment = HomeFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.container, HomeFragment())
        ft.commit()

        textClose.setOnClickListener {
            slidingPane.closePane()
        }

        imageClose.setOnClickListener {
            slidingPane.closePane()
        }

        textPermanent.setOnClickListener {
            group1.visibility = View.VISIBLE
            group2.visibility = View.GONE
            group3.visibility = View.GONE
        }

        textDuration.setOnClickListener {
            group1.visibility = View.GONE
            group2.visibility = View.VISIBLE
            group3.visibility = View.GONE
        }

        textShort.setOnClickListener {
            group1.visibility = View.GONE
            group2.visibility = View.GONE
            group3.visibility = View.VISIBLE
        }

        textLigadura.setOnClickListener {
            replaceFragment(LigaduraFragment())
            //            startActivity(Intent(this, LigaduraActivity::class.java))
        }

        textVasectomia.setOnClickListener {
            //            startActivity(Intent(this, VasectomiaActivity::class.java))
            replaceFragment(VasectomiaFragment())
        }

        textCobre.setOnClickListener {
            //            startActivity(Intent(this, CobreActivity::class.java))
            replaceFragment(CobreFragment())
        }

        textHormonas.setOnClickListener {
            replaceFragment(HormonasFragment())
//            startActivity(Intent(this, HormonasActivity::class.java))
        }

        textImplante.setOnClickListener {
            replaceFragment(ImplanteFragment())
//            startActivity(Intent(this, ImplanteActivity::class.java))
        }

        textInyectable.setOnClickListener {
            replaceFragment(InyectablesFragment())
//            startActivity(Intent(this, InyectablesActivity::class.java))
        }

        textOrales.setOnClickListener {
            replaceFragment(OralesFragment())
//            startActivity(Intent(this, OralesActivity::class.java))
        }

        textParche.setOnClickListener {
            replaceFragment(ParcheFragment())
//            startActivity(Intent(this, ParcheActivity::class.java))
        }

        textAnillo.setOnClickListener {
            replaceFragment(AnilloFragment())
//            startActivity(Intent(this, AnilloActivity::class.java))
        }

        textEmergency.setOnClickListener {
            replaceFragment(EmergencyFragment())
            //            replaceFragment(VasectomiaFragment())
//            startActivity(Intent(this, EmergencyActivity::class.java))
        }

        textPrevention.setOnClickListener {
            replaceFragment(PreventFragment())
            //            startActivity(Intent(this, PreventActivity::class.java))
        }

        textCompare.setOnClickListener {
            replaceFragment(CompareFragment())
            //            startActivity(Intent(this, AnilloActivity::class.java))
        }

        textResults.setOnClickListener {
            replaceFragment(AnalyticsFragment())
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        App.eventUtil.setCurrentScreen(this, fragment)
        currentFragment = fragment
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.container, fragment)
        ft.commit()
        slidingPane.closePane()
    }

    override fun openDrawer() {
        slidingPane.openPane()
    }

    override fun goDetail(fragment: Fragment) {
        replaceFragment(fragment)
    }

    override fun onBackPressed() {
        if (currentFragment is HomeFragment)
            super.onBackPressed()
        else
            replaceFragment(HomeFragment())
    }

    /**

    <android.support.constraint.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <ExpandableListView
    android:id="@+id/expandableList"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:groupIndicator="@null">

    </ExpandableListView>

    </android.support.constraint.ConstraintLayout>


     ------------------------------------------------------

    package com.example.scardoso.myapplication.view.adapter

    import android.content.Context
    import android.view.LayoutInflater
    import android.view.View
    import android.view.ViewGroup
    import android.widget.BaseExpandableListAdapter
    import android.widget.TextView
    import com.example.scardoso.myapplication.R

    class CategoryAdapter(val context: Context, val data: ArrayList<String>, val childs: HashMap<String, List<String>>) : BaseExpandableListAdapter() {

    override fun getGroup(p0: Int): Any {
    return data[p0]
    }

    override fun getChild(listPosition: Int, expandedListPosition: Int): String? {
    return childs[data[listPosition]]!![expandedListPosition]
    }

    override fun getChildId(p0: Int, p1: Int): Long {
    return p1.toLong()
    }

    override fun getChildView(p0: Int, p1: Int, p2: Boolean, view: View?, p4: ViewGroup?): View {
    var c = view
    if (view == null) {
    val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    c = inflater.inflate(R.layout.item_child, null)
    }
    val textName = c?.findViewById<TextView>(R.id.textName)
    textName?.text = childs[data[p0]]!![p1]
    return c!!
    }

    override fun isChildSelectable(p0: Int, p1: Int): Boolean {
    return true
    }

    override fun hasStableIds(): Boolean {
    return false
    }

    override fun getGroupView(p0: Int, p1: Boolean, view: View?, parent: ViewGroup?): View {
    var c = view
    if (view == null) {
    val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    c = inflater.inflate(R.layout.item_group, parent, false)
    }
    val textTitle = c!!.findViewById<TextView>(R.id.textTitle)
    textTitle?.text = data[p0]
    return c
    }

    override fun getChildrenCount(p0: Int): Int {
    return childs[data[p0]]?.size ?: 0
    }

    override fun getGroupId(p0: Int): Long {
    return p0.toLong()
    }

    override fun getGroupCount(): Int {
    return data.size
    }

    ------------------------------------------------------------------------------------
    
    class Activity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_2)
    val childs = data
    val data = childs.keys
    val adapter = CategoryAdapter(this, ArrayList(data), childs)
    expandableList.setAdapter(adapter)
    }

    val data: HashMap<String, List<String>>
    get() {
    val listData = HashMap<String, List<String>>()

    val redmiMobiles = ArrayList<String>()
    redmiMobiles.add("Redmi Y2")
    redmiMobiles.add("Redmi S2")
    redmiMobiles.add("Redmi Note 5 Pro")
    redmiMobiles.add("Redmi Note 5")
    redmiMobiles.add("Redmi 5 Plus")
    redmiMobiles.add("Redmi Y1")
    redmiMobiles.add("Redmi 3S Plus")

    val micromaxMobiles = ArrayList<String>()
    micromaxMobiles.add("Micromax Bharat Go")
    micromaxMobiles.add("Micromax Bharat 5 Pro")
    micromaxMobiles.add("Micromax Bharat 5")
    micromaxMobiles.add("Micromax Canvas 1")
    micromaxMobiles.add("Micromax Dual 5")

    val appleMobiles = ArrayList<String>()
    appleMobiles.add("iPhone 8")
    appleMobiles.add("iPhone 8 Plus")
    appleMobiles.add("iPhone X")
    appleMobiles.add("iPhone 7 Plus")
    appleMobiles.add("iPhone 7")
    appleMobiles.add("iPhone 6 Plus")

    val samsungMobiles = ArrayList<String>()
    samsungMobiles.add("Samsung Galaxy S9+")
    samsungMobiles.add("Samsung Galaxy Note 7")
    samsungMobiles.add("Samsung Galaxy Note 5 Dual")
    samsungMobiles.add("Samsung Galaxy S8")
    samsungMobiles.add("Samsung Galaxy A8")
    samsungMobiles.add("Samsung Galaxy Note 4")

    listData["Redmi"] = redmiMobiles
    listData["Micromax"] = micromaxMobiles
    listData["Apple"] = appleMobiles
    listData["Samsung"] = samsungMobiles

    return listData
    }


    }


    }

     */
}