package com.teda.miaanticonceptivos.ui.fragment

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.teda.miaanticonceptivos.ui.MainCallback
import com.teda.miaanticonceptivos.R

class TipFragment : Fragment() {

    lateinit var mainCallback: MainCallback

    companion object {
        var TITLE = "TITLE"
        var CIRCLE = "CIRCLE"
        var ICON = "ICON"

        fun newInstance(title: String, circle: Int, icon: Int): TipFragment {
            val fragment = TipFragment()
            val args = Bundle()
            args.putString(TITLE, title)
            args.putInt(CIRCLE, circle)
            args.putInt(ICON, icon)
            fragment.arguments = args
            return fragment
        }
    }

    lateinit var title: String
    var circle: Int = 0
    var icon: Int = 0

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is MainCallback)
            mainCallback = context
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = arguments!!.getString(TITLE)
        circle = arguments!!.getInt(CIRCLE)
        icon = arguments!!.getInt(ICON)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_tip, container, false)
        return v
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        textTitle.text = title
//        imageCircle.setImageDrawable(ContextCompat.getDrawable(context!!, circle))
//        imageIcon.setImageDrawable(ContextCompat.getDrawable(context!!, icon))
//        include.setOnClickListener {

//        }
    }

}