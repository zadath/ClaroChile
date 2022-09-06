package com.example.clarochile.sharedpreferences

import android.content.Context

class PrefsServices(val context: Context) {

    val SHARED_STORAGE = "MydtbServices"
    val SHARED_SERVICIO = "servicio"
    val SHARED_COMBO = "combo"

    val storage = context.getSharedPreferences(SHARED_STORAGE, 0)

    fun saveServicio(servicio:String){
        storage.edit().putString(SHARED_SERVICIO, servicio).apply()
    }

    fun getServicio():String{
        return storage.getString(SHARED_SERVICIO, "")!!
    }


    fun saveCombo(combo:String){
        storage.edit().putString(SHARED_COMBO, combo).apply()
    }

    fun getCombo():String{
        return storage.getString(SHARED_COMBO, "")!!
    }
}