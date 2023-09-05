package com.romakumari.sharedprefrencescolorlist

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.EditText
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.graphics.toColor

class ListAdapter (var colorlist:Int,var color1: String, var color2: String ): BaseAdapter(){
    override fun getCount(): Int {
        return colorlist
    }

    override fun getItem(p0: Int): Any {
        return 1
    }

    override fun getItemId(p0: Int): Long {
       return 1L
    }

   override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View? {
       var view = LayoutInflater.from(p2?.context).inflate(R.layout.colorlistlayout, p2, false)
        var cl = view.findViewById<TextView>(R.id.cl)
        System.out.println("color1 $color1 color2 $color2")

       if(p0 % 2 == 0){
           cl.setBackgroundColor(Color.parseColor(color1))
           cl.setText(color1)
       }else{
           cl.setBackgroundColor(Color.parseColor(color2))
           cl.setText(color2)

       }

        return view
    }





}