package com.example.clarochile.fragments

import androidx.fragment.app.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.clarochile.R
import com.example.clarochile.sharedpreferences.UserSharedPreferences

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.fragment_home.*

class MapsFragment : Fragment() {

    private lateinit var mMap: GoogleMap
    private val permisoFineLocation = android.Manifest.permission.ACCESS_FINE_LOCATION
    private  val permisoCoarseLocation = android.Manifest.permission.ACCESS_COARSE_LOCATION
    private val CODIGO_SOLICITUD_PERMISO = 100
    /*private var fusedLocationClient: FusedLocationProviderClient? = null
    private var locationRequest: LocationRequest? = null*/
    //private var callback: LocationCallback? = null


    private val callback = OnMapReadyCallback { googleMap ->
        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera.
         * In this case, we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user will be prompted to
         * install it inside the SupportMapFragment. This method will only be triggered once the
         * user has installed Google Play services and returned to the app.
         */
        //val mMap = googleMap

        //val sydney = LatLng(-34.0, 151.0)
        val santiago = LatLng(-33.4569400, -70.6482700)

        googleMap.addMarker(MarkerOptions().position(santiago).title("Estás en Santiago"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(santiago))
        //googleMap.maxZoomLevel
        //mMap.setMyLocationEnabled(true)
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_maps, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)


        // Código nuevo de Udemy

       // fusedLocationClient = FusedLocationProviderClient(this)

    }
}