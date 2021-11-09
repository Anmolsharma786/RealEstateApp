package com.example.realestateapp

import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.realestateapp.databinding.ActivityDescriptionBinding
import com.google.firebase.storage.FirebaseStorage
import java.io.File

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

        binding.download.setOnClickListener {
            //ADDING THE IMAGEVIEW BACK
            binding.imageView2.setVisibility(View.VISIBLE)

            val imageName = intent.getStringExtra("propertyAddress").toString()
            val storageRef = FirebaseStorage.getInstance().reference.child("images/$imageName.jpg")

            val localfile = File.createTempFile("tempImage","jpg")
            storageRef.getFile(localfile)
                .addOnSuccessListener {
                val bitmap = BitmapFactory.decodeFile(localfile.absolutePath)
                binding.imageView2.setImageBitmap(bitmap)
                }

            //REMOVING THE BUTTON
            binding.download.setVisibility(View.GONE)
        }
    }
}