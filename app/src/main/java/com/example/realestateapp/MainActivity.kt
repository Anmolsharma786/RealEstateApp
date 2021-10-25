package com.example.realestateapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.realestateapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    //view binding
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //When user is going to click on Login
        binding.loginBtn.setOnClickListener{
            startActivity(Intent(this,LoginActivity::class.java))
        }

        //When user is going to click on SkipBtn
        binding.skipBtn.setOnClickListener{
            startActivity(Intent(this,LoginActivity::class.java))
        }

    }
}