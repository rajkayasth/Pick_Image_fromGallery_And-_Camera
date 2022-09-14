package com.example.pickimagefromgallery

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.FileProvider
import java.io.File

class MainActivity : AppCompatActivity() {
    private lateinit var imgView: ImageView
    private lateinit var btnChange: Button

    private lateinit var imageUri :Uri

    /**function for pick image from Gallery */
//    private val contract = registerForActivityResult(ActivityResultContracts.GetContent()){
//        imgView.setImageURI(it)
//        Log.d("ImageUri",it.toString())
//    }


    private val cameraContracts = registerForActivityResult(ActivityResultContracts.TakePicture()){
        imgView.setImageURI(null)
        imgView.setImageURI(imageUri)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imgView = findViewById(R.id.imageView)
        btnChange = findViewById(R.id.btnChange)

        /**Initiate the contract for picking up the image*/
//        btnChange.setOnClickListener {
//            contract.launch("image/*")
//        }

        imageUri = createImageUri()!!
        btnChange.setOnClickListener {
            cameraContracts.launch(imageUri)
        }
    }

    private fun createImageUri(): Uri? {
        val image = File(applicationContext.filesDir, "camera_photo.png")
        return FileProvider.getUriForFile(
            applicationContext,
            "com.example.pickimagefromgallery.fileProvider",
            image
        )
    }
}