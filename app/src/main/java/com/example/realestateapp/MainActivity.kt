package com.example.realestateapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.example.realestateapp.databinding.ActivityLoginBinding
import com.example.realestateapp.databinding.ActivityMainBinding
import com.example.realestateapp.fragments.CreateFragment
import com.example.realestateapp.fragments.HomeFragment
import com.example.realestateapp.fragments.MessageFragment
import com.google.android.material.navigation.NavigationView


class MainActivity : AppCompatActivity(), PropertyAdapter.PropertyItemListener {


    //firebase Auth
    //view binding
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        // get data from the view model(RecyclerViewAdapter)
        // This gets the data from the Firebase and then passes it to the adapter where adapter will put in child xml and then child xml will to parent xml
        val viewModel : PropertyListViewModel by viewModels()
        viewModel.getRestaurants().observe( this, {
            //passing list of restaurants  we got from "RestaurantListViewModel" as arguments using
            // lambda functions
                restaurants ->
            //creating instance of adapter class
            var propertyAdapter = PropertyAdapter(this, restaurants,this)
            binding.gridRecyclerView.adapter = propertyAdapter
        })








//      When user is going to click on Login
        binding.add.setOnClickListener{
            startActivity(Intent(this,UploadActivity::class.java))

        }


    }

    override fun propertySelected(property: Property) {
        // Here we are going to change the activity
        val intent = Intent(this, DescriptionActivity::class.java)
        // This how we pass the information from one interface to other(This is very case sensitive stuff so make sure it si right)
        intent.putExtra("propertyID", property.id)
        intent.putExtra("propertyAddress", property.address)
        intent.putExtra("propertyPostal", property.postalCode)
        intent.putExtra("propertyCity", property.city)
        intent.putExtra("propertyBed", property.bed)!!.toString()
        intent.putExtra("propertyBath", property.bath)
        intent.putExtra("propertyRoom", property.room)

        // Running the activity
        startActivity(intent)
    }


}