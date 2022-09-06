package com.example.clarochile.sharedpreferences

import android.content.Context

class PrefsAgenda(val context: Context) {

    val SHARED_STORAGE = "MydtbAgenda"
    val SHARED_FECHA = "fecha"
    val SHARED_HORA = "hora"

    val storage = context.getSharedPreferences(SHARED_STORAGE, 0)

    fun saveFecha(fecha:String){
        storage.edit().putString(SHARED_FECHA, fecha).apply()
    }

    fun saveHora(hora:String){
        storage.edit().putString(SHARED_HORA, hora).apply()
    }

    fun getFecha():String{
        return storage.getString(SHARED_FECHA, "")!!
    }

    fun getHora():String{
        return storage.getString(SHARED_HORA, "")!!
    }
}