package com.example.simplenotepad

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.simplenotepad.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val preference = Preference(applicationContext)
        val saveButton = binding.fab

        saveButton.setOnClickListener(){

            val recoveredAnnotation = binding.editContainer.notes.text.toString()

            if (recoveredAnnotation == ""){
                Toast.makeText(this, "Type something...", Toast.LENGTH_SHORT).show()
            }
            else{
                preference.SaveAnnotation(recoveredAnnotation)
                Toast.makeText(this, "The notes were saved successfully!", Toast.LENGTH_SHORT).show()
            }

            val annotation = preference.RecoverAnnotation()

            if (annotation != ""){
                binding.editContainer.notes.setText(annotation)
            }

        }

    }





}