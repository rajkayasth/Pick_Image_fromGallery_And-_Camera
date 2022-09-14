package com.example.pickimagefromgallery

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {
    lateinit var imgView : ImageView
    lateinit var btnChange : Button

    private val contract = registerForActivityResult(ActivityResultContracts.GetContent()){
        imgView.setImageURI(it)
        Log.d("ImageUri",it.toString())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imgView = findViewById(R.id.imageView)
        btnChange = findViewById(R.id.btnChange)

        btnChange.setOnClickListener {
            contract.launch("image/*")
        }

    }
}