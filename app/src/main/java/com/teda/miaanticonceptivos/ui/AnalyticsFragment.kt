package com.teda.miaanticonceptivos.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.teda.miaanticonceptivos.R
import com.teda.miaanticonceptivos.data.model.TimeAnalytics
import kotlinx.android.synthetic.main.activity_analytics.*

class AnalyticsFragment : Fragment() {


    var times = ArrayList<TimeAnalytics?>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.activity_analytics, container, false)
        return v
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var firebase = FirebaseDatabase.getInstance().getReference("time")
        firebase.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {

            }

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (data in dataSnapshot.children) {
                    val time = TimeAnalytics((data.child("duration").value as Long).toInt())
                    times.add(time)
                }
                textCount?.text = times.size.toString()
                if (times.isNotEmpty()) {
                    var avgTime = 0
                    for (time in times) {
                        avgTime += time?.duration!!
                    }
                    textAvgTime?.text = (avgTime / times.size).toString()
                    val max = times.sortedByDescending {
                        it?.duration
                    }
                    textMax?.text = max.first()?.duration.toString()
                    val min = times.sortedBy {
                        it?.duration
                    }
                    textMin?.text = min.first()?.duration.toString()
                }
            }

        })
    }

}