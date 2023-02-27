package com.example.firestapp

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.firestapp.databinding.ActivityMainBinding
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    val db = Firebase.firestore
    var name: String = ""
    var id: String = ""
    var age: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.save.setOnClickListener {

            name = binding.editTextTextPersonName.text.toString()
            id = binding.editTextNumber.text.toString()
            age = binding.editTextNumber2.text.toString()
            this.myFirebase()
        }


    }

    fun myFirebase() {
        // Create a new user with a first and last name
        val persone = hashMapOf(
            "name" to name,
            "id" to id,
            "age" to age
        )

// Add a new document with a generated ID
        db.collection("persone")
            .add(persone)
            .addOnSuccessListener { documentReference ->
                Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
                Toast.makeText(this, " ${documentReference.id}", Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener { e ->
                Log.w(TAG, "Error adding document", e)
            }
    }
}