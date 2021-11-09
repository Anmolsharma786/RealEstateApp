package com.example.realestateapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.realestateapp.databinding.ActivityDescriptionBinding

class DescriptionActivity : AppCompatActivity() {
    private lateinit var binding : ActivityDescriptionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDescriptionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // intent is going to make sure that we get the ids from previous xml
        binding.address.text = intent.getStringExtra("propertyAddress")
        binding.postal.text = intent.getStringExtra("propertyPostal")
        binding.city.text = intent.getStringExtra("propertyCity")
        binding.bed.text = intent.getIntExtra("propertyBed",0).toString()
        binding.bath.text = intent.getIntExtra("propertyBath",0).toString()
        binding.room.text = intent.getIntExtra("propertyRoom",0).toString()


        val propertyID = intent.getStringExtra("propertyID")

    }
}