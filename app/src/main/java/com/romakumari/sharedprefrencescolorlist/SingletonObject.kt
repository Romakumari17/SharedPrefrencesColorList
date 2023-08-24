package com.romakumari.sharedprefrencescolorlist

object SingletonObject {
    init {
        println("in singleton init")
        }

    val sharedPref : SharedPref = SharedPref()
    }
