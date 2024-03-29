package com.example.appquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val myButton= findViewById<Button>(R.id.ActivityMain_Button_Play)
        myButton.setOnClickListener{
            startActivity(Intent(this,Question1::class.java))
        }
    }
}