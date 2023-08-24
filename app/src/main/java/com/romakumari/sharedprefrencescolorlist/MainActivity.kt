package com.romakumari.sharedprefrencescolorlist

import android.content.Context
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.edit
import com.romakumari.sharedprefrencescolorlist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
     lateinit var binding: ActivityMainBinding
     lateinit var sharedPreferences:SharedPreferences
     lateinit var editor:SharedPreferences.Editor
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        SingletonObject.sharedPref.initPref(this)
        sharedPreferences=getSharedPreferences(resources.getString(R.string.app_name),Context.MODE_PRIVATE)
        editor=sharedPreferences.edit()
        SingletonObject.sharedPref.getString(AppConstant.name)
        binding.ettext.setText(sharedPreferences.getString("name",""))
            binding.btnSave.setOnClickListener {
                if (binding.ettext.text.isEmpty()){
                    binding.ettext.error="enter text to save"
            }
                else{
                    editor.putString("Name",binding.ettext.text.toString())
                    editor.apply ()
                    editor.commit()

                    SingletonObject.sharedPref.savingString(AppConstant.name, binding.ettext.text.toString())
                }
                }
        }


    }
