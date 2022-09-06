package com.example.clarochile.sharedpreferences

import android.content.Context

class Prefs(val context:Context){

    val SHARED_NAME = "Mydtb"
    val SHARED_USER_NAME = "username"
    val SHARED_PATERNO = "paterno"
    val SHARED_MATERNO = "materno"
    val SHARED_RUT = "rut"
    val SHARED_MOVIL = "movil"
    val SHARED_CORREO = "correo"


    val storage = context.getSharedPreferences(SHARED_NAME, 0)

    fun saveName(name:String){
        storage.edit().putString(SHARED_USER_NAME, name).apply()
    }

    fun savePaterno(paterno:String){
        storage.edit().putString(SHARED_PATERNO, paterno).apply()
    }

    fun saveMaterno(materno:String){
        storage.edit().putString(SHARED_MATERNO, materno).apply()
    }

    fun saveRut(rut:String){
        storage.edit().putString(SHARED_RUT, rut).apply()
    }

    fun saveMovil(movil:String){
        storage.edit().putString(SHARED_MOVIL, movil).apply()
    }

    fun saveCorreo(correo:String){
        storage.edit().putString(SHARED_CORREO, correo).apply()
    }

    fun getName():String{
        return storage.getString(SHARED_USER_NAME, "")!!
    }

    fun getPaterno():String{
        return storage.getString(SHARED_PATERNO, "")!!
    }

    fun getMaterno():String{
        return storage.getString(SHARED_MATERNO, "")!!
    }

    fun getRut():String{
        return storage.getString(SHARED_RUT, "")!!
    }

    fun getMovil():String{
        return storage.getString(SHARED_MOVIL, "")!!
    }

    fun getCorreo():String{
        return storage.getString(SHARED_CORREO, "")!!
    }

}