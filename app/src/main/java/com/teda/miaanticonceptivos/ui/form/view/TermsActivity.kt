package com.teda.miaanticonceptivos.ui.form.view

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.teda.miaanticonceptivos.App
import com.teda.miaanticonceptivos.R
import com.teda.miaanticonceptivos.ui.form.presenter.TermsContract
import com.teda.miaanticonceptivos.ui.form.presenter.TermsPresenter
import kotlinx.android.synthetic.main.activity_terms.*

class TermsActivity : AppCompatActivity(), TermsContract.View {

    private val presenter by lazy { TermsPresenter(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_terms)
        presenter.getTerms()
        imageView4.setOnClickListener {
            App.eventUtil.newSession()
            onBackPressed()
        }
    }

    override fun showTerms(terms: String) {
        val nTerms = terms.replace("_b", "\n")
        textTerms.text = nTerms
    }
}
