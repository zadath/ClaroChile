package com.example.clarochile

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.TextKeyListener.clear
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import com.example.clarochile.sharedpreferences.UserSharedPreferences
import com.example.clarochile.sharedpreferences.UserSharedPreferences.Companion.prefs
import com.google.android.material.button.MaterialButton

class ContratoExitoso : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contrato_exitoso)

        val textOrden = findViewById<TextView>(R.id.textViewOrden)
        textOrden.text = UserSharedPreferences.prefsContract.getOrdenservicio()
        val botonIrInicio = findViewById<MaterialButton>(R.id.botonIrInicio)

        //Limpiar SharedPreferences
        this.getSharedPreferences("Mydtb", 0).edit().clear().apply()
        this.getSharedPreferences("MydtbAddress", 0).edit().clear().apply()
        this.getSharedPreferences("MydtbAgenda", 0).edit().clear().apply()
        this.getSharedPreferences("MydtbContract", 0).edit().clear().apply()
        this.getSharedPreferences("MydtbServices", 0).edit().clear().apply()

        botonIrInicio.setOnClickListener{
            //val intent = Intent(this, UserActivity::class.java)
            val intent = Intent(this, Generico::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, UserActivity::class.java)
        startActivity(intent)
        finish()
    }

}