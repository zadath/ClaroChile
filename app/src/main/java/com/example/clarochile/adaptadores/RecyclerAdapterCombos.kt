package com.example.clarochile.adaptadores

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.clarochile.R
import com.example.clarochile.base.BaseViewHolder
import com.example.clarochile.modelo.Combo
import kotlinx.android.synthetic.main.combos_row.view.*
import kotlinx.android.synthetic.main.servicios_row.view.*

class RecyclerAdapterCombos(private val context: Context, val listCombos:List<Combo>,
                            private val itemClickListener: onComboClickListener): RecyclerView.Adapter<BaseViewHolder<*>>() {


    interface onComboClickListener{
        fun onImageClickCombo(foto: Int)
        fun onItemClickCombo(nombre: String)

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        return CombosViewHolder(LayoutInflater.from(context).inflate(R.layout.combos_row, parent, false))
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when(holder){
            is CombosViewHolder -> holder.bind(listCombos[position], position)
            else -> IllegalAccessException("Se olvidó enviar el ViewHolder correcto en el Bind")
        }
    }

    override fun getItemCount(): Int = listCombos.size

    inner class CombosViewHolder(itemView: View): BaseViewHolder<Combo>(itemView){
        override fun bind(item: Combo, position: Int){
            itemView.setOnClickListener{itemClickListener.onItemClickCombo(item.nombre)}
            itemView.img_auto.setOnClickListener{itemClickListener.onImageClickCombo(item.foto)}
            itemView.txt_nombre_combo.text = item.nombre
            itemView.txt_descripcion_combo.text = item.descripcion
            itemView.txt_precio_combo.text = item.precio
            itemView.img_auto.setImageResource(item.foto)
        }
    }
}