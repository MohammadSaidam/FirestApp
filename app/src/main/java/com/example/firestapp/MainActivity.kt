package com.example.firestapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.firestapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.name.text = "Mohammed Saidam"


    }
}