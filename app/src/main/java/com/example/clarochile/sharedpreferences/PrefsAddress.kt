package com.example.clarochile.sharedpreferences

import android.content.Context

class PrefsAddress(val context: Context) {

    val SHARED_STORAGE = "MydtbAddress"
    val SHARED_REGION = "region"
    val SHARED_PROVINCIA = "provincia"
    val SHARED_COMUNA = "comuna"
    val SHARED_CALLE = "calle"
    val SHARED_NUMERO = "numero"


    val storage = context.getSharedPreferences(SHARED_STORAGE, 0)

    fun saveRegion(region:String){
        storage.edit().putString(SHARED_REGION, region).apply()
    }

    fun saveProvincia(provincia:String){
        storage.edit().putString(SHARED_PROVINCIA, provincia).apply()
    }

    fun saveComuna(comuna:String){
        storage.edit().putString(SHARED_COMUNA, comuna).apply()
    }

    fun saveCalle(calle:String){
        storage.edit().putString(SHARED_CALLE, calle).apply()
    }

    fun saveNumero(numero:String){
        storage.edit().putString(SHARED_NUMERO, numero).apply()
    }

    fun getRegion():String{
        return storage.getString(SHARED_REGION, "")!!
    }

    fun getProvincia():String{
        return storage.getString(SHARED_PROVINCIA, "")!!
    }

    fun getComuna():String{
        return storage.getString(SHARED_COMUNA, "")!!
    }

    fun getCalle():String{
        return storage.getString(SHARED_CALLE, "")!!
    }

    fun getNumero():String{
        return storage.getString(SHARED_NUMERO, "")!!
    }

}