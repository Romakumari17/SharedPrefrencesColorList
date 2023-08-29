package com.romakumari.sharedprefrencescolorlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.EditText
import androidx.core.graphics.toColor

class ListAdapter (var colorlist:ArrayList<Int>,var listInterface: ListInterface ): BaseAdapter(){
    override fun getCount(): Int {
        return colorlist.size
    }

    override fun getItem(p0: Int): Any {
        return 1
    }

    override fun getItemId(p0: Int): Long {
       return 1L
    }

   override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View? {
       var view = LayoutInflater.from(p2?.context).inflate(R.layout.colorlistlayout, p2, false)
//        var colorlist1 = view.findViewById<EditText>(R.id.colorlist1)
//        var colorlist2 = view.findViewById<EditText>(R.id.colorlist2)
//        // colorlist1.setText(colorlist[position].)
        return view
    }





}