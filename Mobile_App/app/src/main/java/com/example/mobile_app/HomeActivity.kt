package com.example.mobile_app


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.Spinner
import android.widget.TextView

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val spinner1 = findViewById<Spinner>(R.id.spinner1)
        val spinner2 = findViewById<Spinner>(R.id.spinner2)
        val spinner3 = findViewById<Spinner>(R.id.spinner3)

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

        val card1 = findViewById<View>(R.id.card1)
        val propertyImage1 = card1.findViewById<ImageView>(R.id.property_image)
        val propertyTitle1 = card1.findViewById<TextView>(R.id.property_title)
        val propertyPrice1 = card1.findViewById<TextView>(R.id.property_price)
        val propertyLayout1 = card1.findViewById<TextView>(R.id.property_layout)
        val propertyDescription1 = card1.findViewById<TextView>(R.id.property_description)

        propertyImage1.setImageResource(R.drawable.img_casa1)
        propertyTitle1.text = "Nova Propriedade"
        propertyPrice1.text = "Price"
        propertyLayout1.text = "Layout"
        propertyDescription1.text = "Description"

        val card2 = findViewById<View>(R.id.card2)
        val propertyImage2 = card2.findViewById<ImageView>(R.id.property_image)
        val propertyTitle2 = card2.findViewById<TextView>(R.id.property_title)
        val propertyPrice2 = card2.findViewById<TextView>(R.id.property_price)
        val propertyLayout2 = card2.findViewById<TextView>(R.id.property_layout)
        val propertyDescription2 = card2.findViewById<TextView>(R.id.property_description)

        propertyImage2.setImageResource(R.drawable.img_casa2)
        propertyTitle2.text = "Nova Propriedade"
        propertyPrice2.text = "Price"
        propertyLayout2.text = "Layout"
        propertyDescription2.text = "Description"

        val btnLogOut = findViewById<Button>(R.id.btn_logOut)
        btnLogOut.setOnClickListener{
            finish()
        }

        val btnPerfil = findViewById<Button>(R.id.btn_perfil)
        btnPerfil.setOnClickListener {
            val intent = Intent(this, PerfilActivity::class.java)
            startActivity(intent)
        }

    }
}