package com.example.clarochile.fragments


import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.view.ContextMenu
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.clarochile.*
import com.example.clarochile.sharedpreferences.UserSharedPreferences.Companion.prefs
import com.example.clarochile.sharedpreferences.UserSharedPreferences.Companion.prefsAddress
import com.example.clarochile.sharedpreferences.UserSharedPreferences.Companion.prefsAgenda
import com.example.clarochile.sharedpreferences.UserSharedPreferences.Companion.prefsServices
import com.example.clarochile.sharedpreferences.UserSharedPreferences.Companion.prefsContract
import com.google.android.material.button.MaterialButton
import kotlinx.android.synthetic.main.fragment_resumen.*
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.concurrent.thread


class ResumenFragment : Fragment() {

    lateinit var vista: View
    lateinit var metodoCrear: Contratar
    var nombr: String? = null
    var paterno: String? = null
    var materno: String? = null
    var fechaS: String? = null
    var horaS: String? = null
    var xmlRespuesta: String? = null
    var codigoRespuesta: String? = null
    var mensajeRespuesta: String? = null
    var ordenT = ""
    var bandera: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        vista = inflater.inflate(R.layout.fragment_resumen, container, false)
        metodoCrear = Contratar()

        // Agenda
        val fecha = vista.findViewById<TextView>(R.id.textViewFecha)
        val horario = vista.findViewById<TextView>(R.id.textViewHora)

        fechaS = prefsAgenda.getFecha()
        horaS = prefsAgenda.getHora()
        fecha.text = fechaS
        horario.text = horaS

        // Datos del cliente
        val nombre = vista.findViewById<TextView>(R.id.textViewNombre)
        val rut = vista.findViewById<TextView>(R.id.textViewRut)
        val movil = vista.findViewById<TextView>(R.id.textViewMovil)
        val correo = vista.findViewById<TextView>(R.id.textViewCorreo)
        val botonEjecutar = vista.findViewById<MaterialButton>(R.id.btnCrearOrden)
        //val metodoCrearOrden: Contratar


        nombr = prefs.getName()
        paterno = prefs.getPaterno()
        materno = prefs.getMaterno()
        nombre.text = nombr+" "+paterno+" "+materno
        rut.text = prefs.getRut()
        movil.text = prefs.getMovil()
        correo.text = prefs.getCorreo()
        // Domicilio
        val region = vista.findViewById<TextView>(R.id.textViewRegiones)
        val provincia = vista.findViewById<TextView>(R.id.textViewProvincias)
        val comuna = vista.findViewById<TextView>(R.id.textViewComunas)
        val calle = vista.findViewById<TextView>(R.id.textViewCalles)
        val numero = vista.findViewById<TextView>(R.id.textViewNumeros)

        region.text = prefsAddress.getRegion()
        provincia.text = prefsAddress.getProvincia()
        comuna.text = prefsAddress.getComuna()
        calle.text = prefsAddress.getCalle()
        numero.text = prefsAddress.getNumero()

        // Combos y Servicios
        val combo = vista.findViewById<TextView>(R.id.textViewCombo)
        val comboDesc = vista.findViewById<TextView>(R.id.textViewDescripcion)
        val comboCosto = vista.findViewById<TextView>(R.id.textViewCosto)
        val servicio = vista.findViewById<TextView>(R.id.textViewServicio)
        val servicioDesc = vista.findViewById<TextView>(R.id.textViewDescServicio)
        val servicioCosto = vista.findViewById<TextView>(R.id.textViewCostoCombo)

        combo.text = prefsServices.getServicio()
        comboDesc.text = "Contenido del Combo"
        comboCosto.text = "$ 4,990"

        servicio.text = prefsServices.getCombo()
        servicioDesc.text = "Descripción del Servicio"
        servicioCosto.text = "1,590"




        botonEjecutar.setOnClickListener{

            Thread(Runnable {
                //xmlRespuesta = ""
                xmlRespuesta= metodoCrear.consultar(xmlRespuesta)
                println("Desde el Thread")
                println("Recibimos la respuesta en Corrutina: "+ xmlRespuesta)

                if(xmlRespuesta.isNullOrEmpty()){
                    println("No obtuvimos respuesta éxitosa")
                    prefsContract.saveTipoError("conectividad")
                    val intent = Intent(context, ContratoNoExitoso::class.java)
                    startActivity(intent)
                }else {
                    codigoRespuesta = xmlRespuesta!!.substring(300, 303)
                    mensajeRespuesta = xmlRespuesta!!.substring(315, 355)
                    ordenT = xmlRespuesta!!.substring(339, 346)
                    //bandera = 1
                    guardarDatos()
                    validarAcciones()
                }
                   /* if(bandera == 1){
                        validarAcciones()
                    }*/
            }).start()


            /*if(bandera == 1){
                validarAcciones()
            }*/

            //Test corrutinas
            /*CoroutineScope(Dispatchers.IO).launch {
                xmlRespuesta = ""
                xmlRespuesta= metodoCrear.consultar(xmlRespuesta)
                println("Recibimos la respuesta en Corrutina: "+ xmlRespuesta)

                if(xmlRespuesta.isNullOrEmpty()){
                    println("No obtuvimos respuesta éxitosa")
                }else {
                    codigoRespuesta = xmlRespuesta!!.substring(300, 303)
                    mensajeRespuesta = xmlRespuesta!!.substring(315, 355)
                    ordenT = xmlRespuesta!!.substring(339, 346)
                    guardarDatos()
                }
            }*/

            /*val thread = Thread(Runnable {
                println("Ejecucion del metodo CrearOrden: ")
                xmlRespuesta = ""
                xmlRespuesta= metodoCrear.consultar(xmlRespuesta)
                println("Recibimos la respuesta en ResumenFragment: "+ xmlRespuesta)
                if(xmlRespuesta.isNullOrEmpty()){
                    println("No obtuvimos respuesta éxitosa")
                }else{
                    codigoRespuesta = xmlRespuesta!!.substring(300, 303)
                    mensajeRespuesta = xmlRespuesta!!.substring(315, 355)
                    ordenT = xmlRespuesta!!.substring(339, 346)
                    guardarDatos()

                    // comentaré este código e intentaré procesar fuera del thread  *******
                    /*if(codigoRespuesta == "0</"){

                        println("El número de orden tipo string es: "+ ordenT)
                        println("El número de orden tipo entero es: "+ orden)
                        val intent = Intent(context, UserActivity::class.java)
                        startActivity(intent)
                    }else{ // Camino del error
                        //Toast.makeText(context, "El cliente ya existe!", Toast.LENGTH_LONG).show()
                        println("El código de respuesta es: "+ codigoRespuesta)

                        println("El mensaje de respuesta es: "+ mensajeRespuesta)
                        val builder = AlertDialog.Builder(context)
                        builder.setTitle("Contrataciones Claro CL")
                        builder.setMessage("No se pudo completar la contratación")
                        builder.show()
                    }*/   //Hasta aquí *************
                }
            })*/

           /* kotlin.run {
                thread.start()
            }*/
        }

        return vista
    }

    private fun validarAcciones() {
        val xmlRes = prefsContract.getXMLResponse()
        val codigo = prefsContract.getCodigo()
        val mensaje = prefsContract.getMensaje()
        val ordenS = prefsContract.getOrdenservicio()

        println("Estoy funcion validar acciones! ")
        println("Datos SharedPreferences XmlRes= "+xmlRes)
        println("Datos SharedPreferences codig= "+ codigo)
        println("Datos SharedPreferences mensaje= "+ mensaje)
        println("Datos SharedPreferences orden= "+ ordenS)

        if(codigo == "0</"){
            val intent = Intent(context, ContratoExitoso::class.java)
            startActivity(intent)

        }else{
            println("El código de respuesta sharedPrefs: "+ codigo)
            println("El mensaje de respuesta sharedPrefs: "+ mensaje)
            println("El mensaje de Error es "+ mensaje)
            val intent = Intent(context, ContratoNoExitoso::class.java)
            startActivity(intent)

        }
    }

    private fun creaContrato(){
        CoroutineScope(Dispatchers.IO).launch {
            xmlRespuesta = ""
            xmlRespuesta= metodoCrear.consultar(xmlRespuesta)
            println("Recibimos la respuesta en Corrutina: "+ xmlRespuesta)

            if(xmlRespuesta.isNullOrEmpty()){
                println("No obtuvimos respuesta éxitosa")
            }else {
                codigoRespuesta = xmlRespuesta!!.substring(300, 303)
                mensajeRespuesta = xmlRespuesta!!.substring(315, 355)
                ordenT = xmlRespuesta!!.substring(339, 346)
                bandera = 1
                guardarDatos()
            }
        }
        if(bandera == 1){
            validarAcciones()
        }

    }

    private fun guardarDatos() {
        // SharedPreferences
        prefsContract.saveXMLResponse(xmlRespuesta!!)
        prefsContract.saveCodigo(codigoRespuesta!!)
        prefsContract.saveMensaje(mensajeRespuesta!!)
        prefsContract.saveOrdenservicio(ordenT!!)
    }

}