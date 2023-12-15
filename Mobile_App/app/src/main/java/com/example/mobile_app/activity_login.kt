package com.example.mobile_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class activity_login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        val btnRegister = findViewById<TextView>(R.id.btn_signUp)
        btnRegister.setOnClickListener {
            val intent = Intent(this, activity_register::class.java)
            startActivity(intent)
        }
    }
}