package com.romakumari.sharedprefrencescolorlist

import android.app.Dialog

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.view.ViewGroup
import com.github.dhaval2404.colorpicker.ColorPickerDialog
import com.github.dhaval2404.colorpicker.model.ColorShape
import com.romakumari.sharedprefrencescolorlist.databinding.ActivityMainBinding
import com.romakumari.sharedprefrencescolorlist.databinding.ColorlayoutBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var sharedPreferences: SharedPreferences
    lateinit var editor: SharedPreferences.Editor
    lateinit var colorlist: ArrayList<AppConstant>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        SingletonObject.sharedPref.initPref(this)
        sharedPreferences =
            getSharedPreferences(resources.getString(R.string.app_name), Context.MODE_PRIVATE)
        editor = sharedPreferences.edit()

        binding.mainActivity=this

    }

    fun FabClick() {
        var dialog = Dialog(this)
        var dialogbinding = ColorlayoutBinding.inflate(layoutInflater)
        dialogbinding.mainActivity=this
        dialog.setContentView(dialogbinding.root)
        dialog.getWindow()?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
            dialog.show()

                }

    fun ClearClick() {

    }
    fun SaveClick(){

    }
    fun SaveColor(type:Int){
        ColorPickerDialog
            .Builder(this)
            .setTitle("pick color")
            .setColorShape(ColorShape.SQAURE)
            .setDefaultColor(R.color.white)
            .setColorListener { color, colorHex ->
                System.out.println("color $color colorHex $colorHex")
            }
            .show()
        SingletonObject.sharedPref.getString(1)
        SingletonObject.sharedPref.getString(2)

        

    }
   fun Savenumber(){

   }

}





