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

        val spinner1 = findViewById<Spinner>(R.id.select1)
        val spinner2 = findViewById<Spinner>(R.id.select2)
        val spinner3 = findViewById<Spinner>(R.id.select3)

        // Exemplo para o Spinner "Teste"
        val testeData = arrayOf("Aluguer", "Compra")
        val testeAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, testeData)
        testeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner1.adapter = testeAdapter

        // Exemplo para o Spinner "Tipo"
        val tipoData = arrayOf("Andar", "Moradia")
        val tipoAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, tipoData)
        tipoAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner2.adapter = tipoAdapter

        // Exemplo para o Spinner "Topologia"
        val topologiaData = arrayOf("T1", "T2", "T3", "T4+")
        val topologiaAdapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_item, topologiaData)
        topologiaAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner3.adapter = topologiaAdapter


        val btnAbout = findViewById<Button>(R.id.btn_about)
        btnAbout.setOnClickListener {
            val intent = Intent(this, activity_about::class.java)
            startActivity(intent)
        }

        val btnLogin = findViewById<Button>(R.id.btn_login)
        btnLogin.setOnClickListener {
            val intent = Intent(this, activity_login::class.java)
            startActivity(intent)
        }
    }
}
