package com.lala.sharedpref

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.lala.sharedpref.databinding.ActivityMainBinding
import java.util.prefs.AbstractPreferences

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPreferences = getSharedPreferences("Person", MODE_PRIVATE)
        setUpClickListeners()
        getData()
    }

    fun setUpClickListeners() {
        binding.button.setOnClickListener{
            save()
        }

    }

    fun save() {
        val personName = binding.editText.text.toString()
        sharedPreferences.edit().putString("personName", personName).apply()
    }

    fun getData() {
        val savedData = sharedPreferences.getString("personName", "")
        binding.editText.setText(savedData)
    }
}