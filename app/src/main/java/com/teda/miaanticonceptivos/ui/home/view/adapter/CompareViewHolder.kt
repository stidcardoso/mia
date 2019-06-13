package com.teda.miaanticonceptivos.ui.home.view.adapter

import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.View
import com.teda.miaanticonceptivos.R
import com.teda.miaanticonceptivos.data.model.Method
import kotlinx.android.synthetic.main.item_compare_method.view.*

class CompareViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(method: Method) {
        method.icon?.let { itemView.imageRes.setImageResource(it) }
        itemView.textMethodName.text = method.name
        when (adapterPosition) {
            in 0..1 -> {
                setColor(R.color.red_compare)
            }
            in 2..4 -> {
                setColor(R.color.purple_compare)
            }
            in 5..7 -> {
                setColor(R.color.purple_light_compare)
            }
            in 8..9 -> {
                setColor(R.color.purple_compare)
            }
        }
    }

    private fun setColor(color: Int) {
        val context = itemView.context
        itemView.setBackgroundColor(ContextCompat.getColor(context, color))
    }

}