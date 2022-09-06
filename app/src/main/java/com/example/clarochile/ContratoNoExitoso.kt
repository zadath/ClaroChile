package com.example.clarochile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.clarochile.sharedpreferences.UserSharedPreferences.Companion.prefsContract
import com.google.android.material.button.MaterialButton

class ContratoNoExitoso : AppCompatActivity() {

    var tipoError: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contrato_no_exitoso)

        val botonInicio = findViewById<MaterialButton>(R.id.botonInicio)
        val botonContratar = findViewById<MaterialButton>(R.id.botonContratar)
        val mensaje = findViewById<TextView>(R.id.textViewMensaje)

        tipoError = prefsContract.getTipoError()

        if(tipoError == "conectividad"){
            mensaje.text = "Hay un problema de conectividad"
        }else{
            mensaje.text = "El RUT tiene orden abierta"
        }


        botonContratar.setOnClickListener{
            val intent = Intent(this, Generico::class.java)
            startActivity(intent)
            finish()
        }

        botonInicio.setOnClickListener{
            limpiarSharedPref()
            val intent = Intent(this, UserActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        limpiarSharedPref()
        val intent = Intent(this, UserActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun limpiarSharedPref(){
        this.getSharedPreferences("Mydtb", 0).edit().clear().apply()
        this.getSharedPreferences("MydtbAddress", 0).edit().clear().apply()
        this.getSharedPreferences("MydtbAgenda", 0).edit().clear().apply()
        this.getSharedPreferences("MydtbContract", 0).edit().clear().apply()
        this.getSharedPreferences("MydtbServices", 0).edit().clear().apply()
    }
}