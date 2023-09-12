package com.romakumari.sharedprefrencescolorlist

import android.app.Dialog

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.github.dhaval2404.colorpicker.ColorPickerDialog
import com.github.dhaval2404.colorpicker.model.ColorShape
import com.romakumari.sharedprefrencescolorlist.databinding.ActivityMainBinding
import com.romakumari.sharedprefrencescolorlist.databinding.ColorlayoutBinding
import com.romakumari.sharedprefrencescolorlist.databinding.ColorlistlayoutBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var sharedPreferences: SharedPreferences
    lateinit var editor: SharedPreferences.Editor
    lateinit var dialog: Dialog
    lateinit var dialogBinding: ColorlayoutBinding
    lateinit var listAdapter: ListAdapter
    var color1 = "#ffffff"
    var color2 = "#ffffff"
    var number = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        SingletonObject.sharedPref.initPref(this)
        sharedPreferences =
            getSharedPreferences(resources.getString(R.string.app_name), Context.MODE_PRIVATE)
        editor = sharedPreferences.edit()
        color1 = SingletonObject.sharedPref.getString(AppConstant.color) ?: "#ffffff"
        color2 = SingletonObject.sharedPref.getString(AppConstant.color2) ?: "#ffffff"
        number = SingletonObject.sharedPref.getInt(AppConstant.number) ?: 0
        listAdapter = ListAdapter()
        listAdapter.updateValues(color1 = color1, color2 = color2, colorList = number)

        binding.listView.adapter = listAdapter
        binding.mainActivity = this

    }

    fun FabClick() {
        dialog = Dialog(this)
        dialogBinding = ColorlayoutBinding.inflate(layoutInflater)
        dialogBinding.mainActivity = this
        dialog.setContentView(dialogBinding.root)
        dialog.getWindow()?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        dialogBinding.etcolor1.setText(color1)
        dialogBinding.etcolor2.setText(color2)
        dialogBinding.etlistno.setText(number.toString())
        dialog.show()

    }

    fun ClearClick() {
        SingletonObject.sharedPref.clearPref()
        color1 = SingletonObject.sharedPref.getString(AppConstant.color)
        color2=SingletonObject.sharedPref.getString(AppConstant.color2)
        number=SingletonObject.sharedPref.getInt(AppConstant.number)
        listAdapter.updateValues(color1 = color1, color2 = color2, colorList = number)

    }

    fun SaveClick() {
        //validations
        SingletonObject.sharedPref.savingString(
            AppConstant.color,
            dialogBinding.etcolor1.text.toString()
        )
        SingletonObject.sharedPref.savingString(
            AppConstant.color2,
            dialogBinding.etcolor2.text.toString()
        )
        SingletonObject.sharedPref.setInt(
            AppConstant.number,
            dialogBinding.etlistno.text.toString().toInt()
        )
        color1 =  dialogBinding.etcolor1.text.toString()
        color2 =  dialogBinding.etcolor2.text.toString()
        number =  dialogBinding.etlistno.text.toString().toInt()
        listAdapter.updateValues(color1 = color1, color2 = color2, colorList = number)

        dialog.dismiss()

    }

    fun SaveColor(type: Int) {
        ColorPickerDialog
            .Builder(this)
            .setTitle("pick color")
            .setColorShape(ColorShape.SQAURE)
            .setDefaultColor(R.color.white)
            .setColorListener { color, colorHex ->
                System.out.println("color $color colorHex $colorHex")
                if (type == 1) {
                    dialogBinding.etcolor1.setText(colorHex)
                } else if (type == 2) {
                    dialogBinding.etcolor2.setText(colorHex)
                }
            }
            .show()
    }



}





