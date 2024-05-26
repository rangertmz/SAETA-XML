package com.example.saeta

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

@SuppressLint("ValidFragment")
class RutaVenidaFragment : Fragment(), OnMapReadyCallback {

    private var mGoogleMap: GoogleMap? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_ruta_venida, container, false)

        val mapFragment = childFragmentManager
            .findFragmentById(R.id.mapFragment) as SupportMapFragment
        mapFragment.getMapAsync(this)

        return view
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            RutaVenidaFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mGoogleMap = googleMap
    }
}