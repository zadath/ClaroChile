package com.example.clarochile.fragments

import android.os.Bundle
import android.support.v4.media.RatingCompat
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import com.example.clarochile.R
import com.example.clarochile.TimePickerFragment
import com.example.clarochile.sharedpreferences.UserSharedPreferences
import com.google.android.material.button.MaterialButton
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener
import kotlinx.android.synthetic.main.fragment_agenda.*
import kotlinx.android.synthetic.main.fragment_agenda.view.*
import kotlinx.android.synthetic.main.fragment_home.*
import java.util.*



class AgendaFragment : Fragment() {

    lateinit var vista: View
    lateinit var editTextReservar: TextView
    lateinit var diaR: String
    lateinit var mesR: String
    lateinit var anioR: String
    lateinit var botonTimePicker: Button
    lateinit var horario: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val c = Calendar.getInstance()
        val dia = c.get(Calendar.DAY_OF_MONTH)
        val mes = c.get(Calendar.MONTH)
        val anio = c.get(Calendar.YEAR)


        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_agenda, container, false)  //original
        vista = inflater.inflate(R.layout.fragment_agenda, container, false)

        val datePick = vista.findViewById<DatePicker>(R.id.datePickerFecha)
        datePick.datePickerFecha.minDate = c.timeInMillis
        val botonReservar = vista.findViewById<MaterialButton>(R.id.botonReservar)
        botonTimePicker = vista.findViewById<MaterialButton>(R.id.botonTimePicker)


        botonTimePicker.setOnClickListener{
            elegirHorario()
        }

        botonReservar.setOnClickListener{
            reservarFecha()
        }
        return vista
    }

    private fun elegirHorario() {
        //val timePicker = TimePickerFragment{time -> onTimeSelected(time)} se reduce como sigue=
        val timePicker = TimePickerFragment{onTimeSelected(it)}
        //timePicker.show(supportFragmentManager, "time")
        timePicker.show(parentFragmentManager, "time")
       // horario = time
    }

    private fun reservarFecha() {
        diaR = datePickerFecha.dayOfMonth.toString()
        mesR = datePickerFecha.month.toString()
        anioR = datePickerFecha.year.toString()

        editTextReservar = vista.findViewById<EditText>(R.id.textViewFechaReservada)
        editTextReservar.setText(diaR+"/"+mesR+"/"+anioR+" "+horario)

        UserSharedPreferences.prefsAgenda.saveFecha(diaR+"/"+mesR+"/"+anioR)

    }

    private fun onTimeSelected(time:String){
        horario = time
        UserSharedPreferences.prefsAgenda.saveHora(horario)
    }
}