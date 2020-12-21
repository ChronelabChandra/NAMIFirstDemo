package com.example.androiddemoapp.views.fragment

import android.Manifest
import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Criteria
import android.location.LocationManager
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import com.example.androiddemoapp.R
import com.google.android.gms.common.api.GoogleApiClient
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng

class MapFragment : Fragment() {
    val TAG = "MapFragment"

    private val permissions = arrayOf(
        Manifest.permission.ACCESS_FINE_LOCATION,
        Manifest.permission.ACCESS_COARSE_LOCATION
    )
    private val PERMISSION_REQUEST_CODE = 1001

    private lateinit var mMap: GoogleMap
    private lateinit var mGoogleApiClient: GoogleApiClient

    var DEFAULT_LOCATION_LAT = 27.7172f
    var DEFAULT_LOCATION_LNG = 85.3240f

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_map, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requestPermission()
    }

    private val callback = OnMapReadyCallback { googleMap ->
        Log.e(TAG, "callback ready")
        mMap = googleMap
        mGoogleApiClient = GoogleApiClient.Builder(requireContext())
            .addConnectionCallbacks(object : ConnectionCallbacks {
                override fun onConnected(bundle: Bundle?) {
                    Log.e(TAG, "Google Api client : connected")
                    initialiseMyLocation()
                    mGoogleApiClient.unregisterConnectionCallbacks(this)
                }

                override fun onConnectionSuspended(i: Int) {
                    Log.e(TAG, "Google Api client : Suspended")
                }
            })
            .addApi(LocationServices.API)
            .build()

        mGoogleApiClient.connect()
    }

    private fun configureMap() {
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)
    }

    private fun checkLocationEnabled(): Boolean {
        val lm = requireContext().getSystemService(Context.LOCATION_SERVICE) as LocationManager
        var gps_enabled = false
        var network_enabled = false
        try {
            gps_enabled = lm.isProviderEnabled(LocationManager.GPS_PROVIDER)
        } catch (ex: Exception) {
            Log.e(TAG, "Error $ex")
        }
        try {
            network_enabled = lm.isProviderEnabled(LocationManager.NETWORK_PROVIDER)
        } catch (ex: Exception) {
            Log.e(TAG, "Error $ex")
        }
        if (!gps_enabled && !network_enabled) {
            // notify user
            val dialog = AlertDialog.Builder(context)
            dialog.setMessage(resources.getString(R.string.enable_gps_message))
            dialog.setPositiveButton(
                resources.getString(R.string.open_location_settings)
            ) { paramDialogInterface, paramInt ->
                val myIntent = Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS)
                startActivity(myIntent)
            }
            dialog.setNegativeButton(
                getString(R.string.cancel)
            ) { paramDialogInterface, paramInt -> }
            dialog.show()
        }
        return true
    }


    @SuppressLint("MissingPermission")
    fun initialiseMyLocation() {
        if (mGoogleApiClient.isConnected) {
            if (!checkLocationEnabled()) {
                Log.e(TAG, "location disabled")
                onLocationChangedLatLong(
                    DEFAULT_LOCATION_LAT,
                    DEFAULT_LOCATION_LNG
                )
            } else {
                mMap.isMyLocationEnabled = true
                mMap.uiSettings.isScrollGesturesEnabled = true
                val manager =
                    requireActivity().getSystemService(Context.LOCATION_SERVICE) as LocationManager
                val mCriteria = Criteria()
                val bestProvider = manager.getBestProvider(mCriteria, true).toString()
                val mLocation = manager.getLastKnownLocation(bestProvider)
                if (mLocation != null) {
                    Log.e("TAG", "GPS is on")
                    val latLng = LatLng(mLocation.latitude, mLocation.longitude)
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15f))
                    mMap.animateCamera(CameraUpdateFactory.zoomTo(14f), 2000, null)
                }
            }
        }
    }

    private fun onLocationChangedLatLong(defaultLocationLat: Any, defaultLocationLng: Any) {
        Log.e(TAG, "location changed")

    }


    private fun hasPermissions(context: Context?, permissions: Array<String>): Boolean {
        for (permission in permissions) {
            if (ActivityCompat.checkSelfPermission(
                    requireContext(),
                    permission
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                return false
            }
        }
        return true
    }


    private fun requestPermission() {
        val status = hasPermissions(requireContext(), permissions)
        if (status) {
            configureMap()
        } else {
            ActivityCompat.requestPermissions(
                requireActivity(),
                permissions,
                PERMISSION_REQUEST_CODE
            )
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            PERMISSION_REQUEST_CODE -> {
                if (grantResults.isNotEmpty()) {
                    requestPermission()
                } else {
                    Toast.makeText(
                        requireContext(),
                        "Location permission needed",
                        Toast.LENGTH_SHORT
                    ).show()
                    ActivityCompat.requestPermissions(
                        requireActivity(),
                        this.permissions,
                        PERMISSION_REQUEST_CODE
                    )
                }
            }
        }
    }


}