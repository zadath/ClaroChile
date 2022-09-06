package com.example.clarochile

import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowInsets
import android.view.WindowManager
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.fragment.app.Fragment
import com.example.clarochile.adaptadores.ViewPagerAdapter
import com.example.clarochile.fragments.*
import com.example.clarochile.sharedpreferences.UserSharedPreferences
import com.google.android.material.button.MaterialButton
import kotlinx.android.synthetic.main.activity_generico.*
import kotlinx.android.synthetic.main.fragment_home.*

class Generico : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_generico)

        @Suppress("DEPRECATION")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        } else {
            window.setFlags(
                    WindowManager.LayoutParams.FLAG_FULLSCREEN,

                    WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }

        setUpTabs()
    }

    private fun setUpTabs() {

        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(HomeFragment(), "")
        adapter.addFragment(AddressFragment(), "")
        adapter.addFragment(PrimeroFragment(), "")
        adapter.addFragment(AgendaFragment(), "")
        adapter.addFragment(ResumenFragment(), "")
        //adapter.addFragment(FourFragment(), "")
        //adapter.addFragment(FiveFragment(), "")

        viewPager.adapter = adapter
        tabs.setupWithViewPager(viewPager)

        tabs.getTabAt(0)!!.setIcon(R.drawable.formulario)
        tabs.getTabAt(1)!!.setIcon(R.drawable.localizacion)
        tabs.getTabAt(2)!!.setIcon(R.drawable.carrito)
        tabs.getTabAt(3)!!.setIcon(R.drawable.reloj)
        tabs.getTabAt(4)!!.setIcon(R.drawable.confirmacion)
        //tabs.getTabAt(3)!!.setIcon(R.drawable.heart)
    }

}