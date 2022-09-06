package com.example.clarochile.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.clarochile.R
import com.example.clarochile.sharedpreferences.UserSharedPreferences
import com.google.android.material.button.MaterialButton
import kotlinx.android.synthetic.main.fragment_address.*
import kotlinx.android.synthetic.main.fragment_home.*

class AddressFragment : Fragment() {

    lateinit var botonGuardar: MaterialButton
    lateinit var vista: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        vista = inflater.inflate(R.layout.fragment_address, container, false)

        botonGuardar = vista.findViewById<MaterialButton>(R.id.botonOk_Address)
        botonGuardar.setOnClickListener{
            guardarDatos()
        }

        return vista
    }

    private fun guardarDatos() {
        // SharedPreferences
        UserSharedPreferences.prefsAddress.saveRegion(editText_region.text.toString())
        UserSharedPreferences.prefsAddress.saveProvincia(editText_provincia.text.toString())
        UserSharedPreferences.prefsAddress.saveComuna(editText_comuna.text.toString())
        UserSharedPreferences.prefsAddress.saveCalle(editText_calle.text.toString())
        UserSharedPreferences.prefsAddress.saveNumero(editText_numero.text.toString())
    }

}