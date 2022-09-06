package com.example.clarochile.fragments

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.clarochile.R
import com.example.clarochile.sharedpreferences.UserSharedPreferences
import com.example.clarochile.sharedpreferences.UserSharedPreferences.Companion.prefs
import com.google.android.material.button.MaterialButton
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment() {

    lateinit var botonGuardar: MaterialButton
    lateinit var vista: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?):
            View? {

        // Inflate the layout for this fragment

        //return inflater.inflate(R.layout.fragment_home, container, false)
        vista = inflater.inflate(R.layout.fragment_home, container, false)

        botonGuardar = vista.findViewById<MaterialButton>(R.id.botonOk)
        botonGuardar.setOnClickListener{
            guardarDatos()
        }
        return vista
    }

    private fun guardarDatos() {
        // SharedPreferences
        prefs.saveName(editText_nombre.text.toString())
        prefs.savePaterno(editText_paterno.text.toString())
        prefs.saveMaterno(editText_materno.text.toString())
        prefs.saveRut(editText_rut.text.toString())
        prefs.saveMovil(editText_movil.text.toString())
        prefs.saveCorreo(editText_correo.text.toString())
    }
}