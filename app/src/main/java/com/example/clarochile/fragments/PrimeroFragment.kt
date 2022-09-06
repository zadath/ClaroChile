package com.example.clarochile.fragments

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.clarochile.R
import com.example.clarochile.UserActivity
import com.example.clarochile.adaptadores.RecyclerAdapter
import com.example.clarochile.adaptadores.RecyclerAdapterCombos
import com.example.clarochile.modelo.Combo
import com.example.clarochile.modelo.Servicio
import com.example.clarochile.sharedpreferences.UserSharedPreferences
import kotlinx.android.synthetic.main.fragment_address.*
import kotlinx.android.synthetic.main.servicios_row.*
import kotlinx.android.synthetic.main.servicios_row.view.*


class PrimeroFragment: Fragment(),RecyclerAdapter.onServicioClickListener, RecyclerAdapterCombos.onComboClickListener{
    //private val appContext = requireContext().applicationContext
    lateinit var contexto:Context //Esto SI funciona
    lateinit var vista: View
    lateinit var recyclerViewServicios: RecyclerView
    lateinit var recyclerViewComb: RecyclerView



    override fun onAttach(context: Context) {  //con esto evito el error de No context attach
        super.onAttach(context)
        this.contexto = context
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {


        // Inflate the layout for this fragment
        vista = inflater.inflate(R.layout.fragment_primero, container, false)
       // return inflater.inflate(R.layout.fragment_primero, container, false)
        recyclerViewServicios = vista.findViewById<RecyclerView>(R.id.recyclerServiciosF)
        recyclerViewComb = vista.findViewById<RecyclerView>(R.id.recyclerCombosF)
        recyclerViewServicios.setHasFixedSize(true)
        recyclerViewComb.setHasFixedSize(true)
        setupRecyclerView()
        setupRecyclerViewCombos()
        return vista
    }

    private fun setupRecyclerView() {
        //var foto: Int = R.drawable.tomater
        //recyclerServicios.layoutManager = LinearLayoutManager(contexto)
        recyclerViewServicios.layoutManager = LinearLayoutManager(contexto)
        recyclerViewServicios.addItemDecoration(DividerItemDecoration(contexto, DividerItemDecoration.VERTICAL))
        val listServicio: List<Servicio> = listOf(
                Servicio(
                        "ESPN",
                        "Transmisiones deportivas 24 horas del día",
                        "$ 3,990",
                        R.drawable.cespn

                ),
                Servicio(
                        "Fox Sports",
                        "Transmisiones deportivas 24 horas del día",
                        "$ 4,770",
                        R.drawable.cfoxsports
                ),
                Servicio(
                        "HBO",
                        "Canal especializado en peliculas",
                        "$ 5,010",
                        R.drawable.chbo
                ),
                Servicio(
                        "Chilevisión",
                        "Canal de contenido regional",
                        "$ 2,770",
                        R.drawable.chilevision
                ),
                Servicio(
                        "Disney Plus",
                        "Plataforma de contenido series y peliculas",
                        "$ 3,770",
                        R.drawable.cdisney
                ),
                Servicio(
                        "MTv",
                        "Canal de videos musicales",
                        "$ 4,770",
                         R.drawable.cmtvdos
                ),
                Servicio(
                        "Netflix",
                        "Plataforma de contenido series y peliculas",
                        "$ 2,970",
                        R.drawable.cnetflix
                ),
                Servicio(
                        "Paramount",
                        "Canal de peliculas",
                        "$ 3,970",
                        R.drawable.cparamount
                ),
                Servicio(
                        "TNT",
                        "Canal de peliculas",
                        "$ 4,770",
                         R.drawable.ctnt
                ),
                Servicio(
                        "AXN",
                        "Canal de diverso contenido",
                        "$ 4,990",
                        R.drawable.naxn
                ),
                Servicio(
                        "TV Azteca",
                        "Canal mexicano",
                        "$ 1,770",
                        R.drawable.nazteca
                ),
                Servicio(
                        "Golden Premier",
                        "Canal de peliculas",
                        "$ 3,770",
                        R.drawable.ngolden
                ),
                Servicio(
                        "Red Bull Tv",
                        "Canal deportes Extremos",
                        "$ 7,770",
                        R.drawable.nredbull
                ),
                Servicio(
                        "Telemundo",
                        "Canal de diverso contenido americano",
                        "$ 2,990",
                        R.drawable.ntelemundo
                ),
                Servicio("TV Chile",
                "Canal de contenido regional",
                "$ 2,990",
                 R.drawable.ctvchile)
        )

        recyclerViewServicios.adapter = RecyclerAdapter(contexto, listServicio, this)

    }

    private fun setupRecyclerViewCombos() {
        //recyclerCombos.layoutManager = LinearLayoutManager(this)
        //recyclerCombosF.layoutManager = LinearLayoutManager(contexto, LinearLayoutManager.HORIZONTAL, false)
        recyclerViewComb.layoutManager = LinearLayoutManager(contexto, LinearLayoutManager.HORIZONTAL, false)
        //recyclerCombos.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL))
        val listCombos: List<Combo> = listOf(
                Combo(
                        "One Play Internet",
                        "Velocidad 20MB",
                        "$ 3,990",
                        R.drawable.clarodos

                ),
                Combo(
                        "One Play Televisión",
                        "Básico 47 canales",
                        "$ 4,770",
                        R.drawable.clarocuatro
                ),
                Combo(
                        "One Play Telefonía",
                        "Minutos nacionales",
                        "$ 5,010",
                        R.drawable.clarodos
                ),
                Combo(
                        "Combo 4",
                        "Descripcion de Básico",
                        "$ 2,770",
                        R.drawable.clarocuatro
                ),
                Combo(
                        "Combo 5",
                        "Descripcion de canales",
                        "$ 3,770",
                        R.drawable.clarodos
                ),
                Combo(
                        "Combo 6",
                        "Descripcion de Universe",
                        "$ 4,770",
                        R.drawable.clarocuatro
                ),
                Combo(
                        "Combo 7",
                        "Descripcion de basico",
                        "$ 2,970",
                        R.drawable.clarodos
                ),
                Combo(
                        "Combo 8",
                        "Descripcion de paquete",
                        "$ 3,970",
                        R.drawable.clarocuatro
                ),
                Combo(
                        "Combo 9",
                        "Descripcion de minutos",
                        "$ 4,770",
                        R.drawable.clarodos
                )
        )

        recyclerViewComb.adapter = RecyclerAdapterCombos(contexto, listCombos, this)

    }

    override fun onImageClick(foto: Int) {
        val intent = Intent(contexto, UserActivity::class.java)
        startActivity(intent)
    }

    override fun onItemClick(nombre: String) {
    //Toast.makeText(contexto, "Seleccionaste el servicio: $nombre", Toast.LENGTH_LONG).show()
    val builder = AlertDialog.Builder(contexto)
        builder.setIcon(R.drawable.carrito)
        builder.setTitle("Tu selección")
        builder.setMessage("Elegiste: $nombre")
                .setPositiveButton("Continuar",
                    DialogInterface.OnClickListener{ dialog, which ->
                       /* dialog.run {
                            val intent = Intent(contexto, UserActivity::class.java)
                            startActivity(intent)
                            //dismiss()
                        }*/
                    } )
                .setNegativeButton("Elegir otro",
                DialogInterface.OnClickListener {dialog, which ->

                })
        builder.create()
        builder.show()
        UserSharedPreferences.prefsServices.saveCombo(nombre)
    }

    override fun onImageClickCombo(foto: Int) {
        val intent = Intent(contexto, UserActivity::class.java)
        startActivity(intent)
    }

    override fun onItemClickCombo(nombre: String) {
        val builder = AlertDialog.Builder(contexto)
        builder.setIcon(R.drawable.carrito)
        builder.setTitle("Tu selección")
        builder.setMessage("Elegiste: $nombre")
                .setPositiveButton("Continuar",
                        DialogInterface.OnClickListener{ dialog, which ->
                            /* dialog.run {
                                 val intent = Intent(contexto, UserActivity::class.java)
                                 startActivity(intent)
                                 //dismiss()
                             }*/
                        } )
                .setNegativeButton("Elegir otro",
                        DialogInterface.OnClickListener {dialog, which ->

                        })
        builder.create()
        builder.show()

        UserSharedPreferences.prefsServices.saveServicio(nombre)
    }


}