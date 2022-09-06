package com.example.clarochile.adaptadores

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.clarochile.R
import com.example.clarochile.base.BaseViewHolder
import com.example.clarochile.modelo.Servicio
import kotlinx.android.synthetic.main.servicios_row.view.*

class RecyclerAdapter (private val context: Context, val listServicio:List<Servicio>,
                       private val itemClickListener:onServicioClickListener):RecyclerView.Adapter<BaseViewHolder<*>>(){



    interface onServicioClickListener{
        fun onImageClick(foto: Int)
        fun onItemClick(nombre: String)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        return ServicioViewHolder(LayoutInflater.from(context).inflate(R.layout.servicios_row, parent, false))
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when(holder){
            is ServicioViewHolder-> holder.bind(listServicio[position], position)
            else -> IllegalAccessException("Se olvidó enviar el ViewHolder correcto en el Bind")
         }
    }

    override fun getItemCount(): Int = listServicio.size


    inner class ServicioViewHolder(itemView: View): BaseViewHolder<Servicio>(itemView){
        override fun bind(item: Servicio, position: Int){
            itemView.setOnClickListener{ itemClickListener.onItemClick(item.nombre)}
            itemView.img_service.setOnClickListener{itemClickListener.onImageClick(item.foto)}
            itemView.txt_nombre_servicio.text = item.nombre
            itemView.txt_descripcion_servicio.text = item.descripcion
            itemView.txt_precio_servicio.text = item.precio
            itemView.img_service.setImageResource(item.foto)

        }
    }

}