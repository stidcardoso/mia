package com.teda.miaanticonceptivos.ui.home.view.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import com.teda.miaanticonceptivos.R
import kotlinx.android.synthetic.main.item_face.view.*

class FaceViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(score: Int, selectedPosition: Int?, arrayPosition: Int) {
        val face = when (score) {
            0 -> {
                R.drawable.face_na
            }
            1 -> {
                R.drawable.face_neutral
            }
            2 -> {
                R.drawable.face_smile
            }
            3 -> {
                R.drawable.face_happy
            }
            else -> {
                R.drawable.face_na
            }
        }
        itemView.imageFace.setImageResource(face)
        /* if (selectedPosition == arrayPosition)
             itemView.viewOver.visibility = View.GONE
         else if (selectedPosition != null)
             itemView.viewOver.visibility = View.VISIBLE*/
        if (selectedPosition == null)
            itemView.viewOver.visibility = View.GONE
        else if (selectedPosition == arrayPosition)
            itemView.viewOver.visibility = View.GONE
        else
            itemView.viewOver.visibility = View.VISIBLE
    }

    fun highlight() {

    }

}