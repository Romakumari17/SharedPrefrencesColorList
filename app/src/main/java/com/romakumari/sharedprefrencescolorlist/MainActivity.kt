package com.romakumari.sharedprefrencescolorlist

import android.app.Dialog
import android.app.Person
import android.content.Context
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import android.graphics.Color
import android.graphics.ColorSpace
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.content.edit
import com.romakumari.sharedprefrencescolorlist.databinding.ActivityMainBinding
import com.romakumari.sharedprefrencescolorlist.databinding.ColorlayoutBinding

class MainActivity : AppCompatActivity() {
     lateinit var binding: ActivityMainBinding
     lateinit var sharedPreferences:SharedPreferences
     lateinit var editor:SharedPreferences.Editor
   //  lateinit var dialog:ColorPickerDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        SingletonObject.sharedPref.initPref(this)
        sharedPreferences =
            getSharedPreferences(resources.getString(R.string.app_name), Context.MODE_PRIVATE)
        editor = sharedPreferences.edit()
        SingletonObject.sharedPref.getString(AppConstant.name)
    }
        fun FabClick() {
            var dialog = Dialog(this)
            var dialogbinding = ColorlayoutBinding.inflate(layoutInflater)
            dialog.setContentView(R.layout.colorlayout)
            dialog.getWindow()?.setLayout(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
//         Toast.makeText(this,"name",Toast.LENGTH_SHORT).show()
            binding.fab = !(binding.fab ?: false)
            dialogbinding.btnsave.setOnClickListener {
                if (dialogbinding.etcolor1.toString().isNullOrEmpty()) {
                    dialogbinding.etcolor1.error = "enter color"
                } else if (dialogbinding.etcolor2.toString().isNullOrEmpty()) {
                    dialogbinding.etcolor2.error = "enter color"

                } else {
                    dialogbinding.etcolor1.setOnContextClickListener {
                                
                        }
                    }


                    }

                    }


                }
            }
            fun ClearClick() {

            }
        }





