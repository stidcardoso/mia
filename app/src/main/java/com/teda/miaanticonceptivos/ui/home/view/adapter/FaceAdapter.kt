package com.teda.miaanticonceptivos.ui.home.view.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.teda.miaanticonceptivos.R


class FaceAdapter(private val list: ArrayList<ArrayList<Int>>) : RecyclerView.Adapter<FaceViewHolder>() {

    private var selectedPosition: Int? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FaceViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_face, parent, false)
        val layoutParams = view.layoutParams
        layoutParams.height = (parent.height * 0.1).toInt()
        view.layoutParams = layoutParams
        return FaceViewHolder(view)
    }

    override fun onBindViewHolder(holder: FaceViewHolder, position: Int) {
        val arrayPosition = position / 10
        val valuePosition = position - (arrayPosition * 10)
        holder.bind(list[arrayPosition][valuePosition], selectedPosition, arrayPosition)
        holder.itemView.setOnClickListener {
            setSelectedPosition(arrayPosition)
        }
    }

    fun setSelectedPosition(position: Int) {
        selectedPosition =
                if (selectedPosition == position)
                    null
                else
                    position
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = list.size * list[0].size


}