package com.teda.miaanticonceptivos.ui.home.view

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.teda.miaanticonceptivos.R
import com.teda.miaanticonceptivos.data.model.Prevention
import com.teda.miaanticonceptivos.ui.MainCallback
import com.teda.miaanticonceptivos.ui.home.presenter.PreventContract
import com.teda.miaanticonceptivos.ui.home.presenter.PreventPresenter
import com.teda.miaanticonceptivos.ui.home.view.adapter.PreventionAdapter
import kotlinx.android.synthetic.main.fragment_prevent.*

class PreventFragment : Fragment(), PreventContract.View {

    lateinit var mainCallback: MainCallback
    private var presenter = PreventPresenter(this)

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is MainCallback)
            mainCallback = context
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_prevent, container, false)
        return v
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.getPrevents()
        drawer.setOnClickListener {
            mainCallback.openDrawer()
        }
    }

    override fun showPrevents(prevents: ArrayList<Prevention>) {
        val adapter = PreventionAdapter(prevents)
        recyclerPrevention.layoutManager = LinearLayoutManager(context)
        recyclerPrevention.adapter = adapter
    }

    override fun onDetach() {
        super.onDetach()
        presenter.onDetach()
    }

}