package com.teda.miaanticonceptivos.ui.home.view.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.teda.miaanticonceptivos.R
import com.teda.miaanticonceptivos.data.model.Method

class CompareAdapter(private val list: ArrayList<Method>, private val listener: Callback) : RecyclerView.Adapter<CompareViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CompareViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_compare_method, parent, false)
        return CompareViewHolder(view)
    }

    override fun onBindViewHolder(holder: CompareViewHolder, position: Int) {
        holder.bind(list[position])
        holder.itemView.setOnClickListener {
            listener.onItemClicked(position)
        }
    }

    override fun getItemCount(): Int = list.size

    interface Callback {

        fun onItemClicked(position: Int)

    }

}