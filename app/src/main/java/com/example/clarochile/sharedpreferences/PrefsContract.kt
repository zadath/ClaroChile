package com.example.clarochile.sharedpreferences

import android.content.Context

class PrefsContract(val context: Context) {

    val SHARED_STORAGE = "MydtbContract"
    val SHARED_XMLRESPONSE = "xmlresponse"
    val SHARED_ORDENSERVICIO = "ordenservicio"
    val SHARED_CODIGO = "codigo"
    val SHARED_MENSAJE = "mensaje"
    val SHARED_TIPOERROR = "tipoerror"


    val storage = context.getSharedPreferences(SHARED_STORAGE, 0)

    // Almacenar datos
    fun saveXMLResponse(xmlResponse:String){
        storage.edit().putString(SHARED_XMLRESPONSE, xmlResponse).apply()
    }

    fun saveOrdenservicio(ordenservicio:String){
        storage.edit().putString(SHARED_ORDENSERVICIO, ordenservicio).apply()
    }

    fun saveCodigo(codigo:String){
        storage.edit().putString(SHARED_CODIGO, codigo).apply()
    }

    fun saveMensaje(mensaje:String){
        storage.edit().putString(SHARED_MENSAJE, mensaje).apply()
    }

    fun saveTipoError(tipoError:String){
        storage.edit().putString(SHARED_TIPOERROR, tipoError).apply()
    }


    // Recuperar datos almacenados
    fun getXMLResponse():String{
        return storage.getString(SHARED_XMLRESPONSE, "")!!
    }

    fun getOrdenservicio():String{
        return storage.getString(SHARED_ORDENSERVICIO, "")!!
    }

    fun getCodigo():String{
        return storage.getString(SHARED_CODIGO, "")!!
    }

    fun getMensaje():String{
        return storage.getString(SHARED_MENSAJE, "")!!
    }

    fun getTipoError():String{
        return storage.getString(SHARED_TIPOERROR, "")!!
    }
}