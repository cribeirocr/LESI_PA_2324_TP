package com.example.mobile_app

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val btnAbout = findViewById<Button>(R.id.btn_about)
        btnAbout.setOnClickListener {
            val intent = Intent(this, activity_about::class.java)
            startActivity(intent)
        }
    }
}
