package com.romakumari.sharedprefrencescolorlist

import android.graphics.drawable.ColorDrawable
import android.text.method.CharacterPickerDialog

object SingletonObject {
    init {
        println("in singleton init")
        }

    val sharedPref : SharedPref = SharedPref()
    }
