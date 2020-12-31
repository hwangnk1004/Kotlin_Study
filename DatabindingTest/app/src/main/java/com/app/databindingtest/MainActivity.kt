package com.app.databindingtest

import android.database.DatabaseUtils
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.app.databindingtest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var text = "Hwang"
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.main = this

        binding.button.setOnClickListener { view ->
            binding.text.setText(text)
        }

    }
}



