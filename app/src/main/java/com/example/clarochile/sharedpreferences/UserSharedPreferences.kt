package com.example.clarochile.sharedpreferences

import android.app.Application

class UserSharedPreferences: Application() {

    companion object{
        lateinit var prefs: Prefs
        lateinit var prefsAddress: PrefsAddress
        lateinit var prefsServices: PrefsServices
        lateinit var prefsAgenda: PrefsAgenda
        lateinit var prefsContract: PrefsContract
    }

    override fun onCreate() {
        super.onCreate()

        prefs = Prefs(applicationContext)
        prefsAddress = PrefsAddress(applicationContext)
        prefsServices = PrefsServices(applicationContext)
        prefsAgenda = PrefsAgenda(applicationContext)
        prefsContract = PrefsContract(applicationContext)
    }
}