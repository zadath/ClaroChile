package com.example.clarochile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView
import com.example.clarochile.fragments.ResumenFragment
import kotlinx.android.synthetic.main.activity_datos_cliente.*

class DatosCliente : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_datos_cliente)

        btn_continuar_datosContrata.setOnClickListener(View.OnClickListener {
            //val intent = Intent(this, Servicios::class.java)
            //startActivity(intent)
            //finish()


            navegarServiciosActivity()
        })
    }

    private fun navegarServiciosActivity(){
        val nombre = findViewById<EditText>(R.id.editText_nombre)
        val paterno  = findViewById<EditText>(R.id.editText_paterno)
        val materno  = findViewById<EditText>(R.id.editText_materno)
        val rut  = findViewById<EditText>(R.id.editText_rut)
        val correo = findViewById<EditText>(R.id.editText_correo)
        val movil = findViewById<EditText>(R.id.editText_movil)
        var name: String? = ""
        name = nombre.text.toString()
        println("Activity DatosCliente....el valor del nombre es= " + name)

       /* val intent = Intent(this, Servicios::class.java)
        intent.putExtra("name", name)*/
        /*intent.putExtra("paterno", paterno)
        intent.putExtra("materno", materno)
        intent.putExtra("rut", rut)
        intent.putExtra("correo", correo)
        intent.putExtra("movil", movil)*/

        //startActivity(intent)
    }

}