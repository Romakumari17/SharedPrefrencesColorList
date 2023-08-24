package com.romakumari.sharedprefrencescolorlist

import android.content.Context
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor

class SharedPref {
    var sharedPref:SharedPreferences?=null
    var Editor:SharedPreferences.Editor?=null
    fun initPref(context:Context){
        if (sharedPref==null){
            sharedPref=context.getSharedPreferences(
                context.resources.getString(R.string.app_name),
                Context.MODE_PRIVATE)
            Editor=sharedPref?.edit()

        }
    }
    fun savingString(key:String,value:String){
        Editor?.putString(key,value)
        Editor?.commit()
    }
    fun getString(name:String):String{
        return sharedPref?.getString(name,"")?:""
    }
    fun clearPref(){
        Editor?.clear()
        Editor?.commit()
    }
}