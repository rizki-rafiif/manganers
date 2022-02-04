package com.rizkirafiif_19104010.manganers

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.rizkirafiif_19104010.manganers.databinding.ActivityMapsBinding

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)



        supportActionBar?.title = myData?.name.toString()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        var lat:Double = myData!!.lat!!
        var lng:Double = myData!!.lang!!
        val location = LatLng(lat, lng)
        mMap.addMarker(MarkerOptions().position(location).title(myData!!.name.toString()))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 16.0f))
    }

    companion object {
        const val EXTRA_MYDATA = "extra_mydata"
    }
    val myData by getParcelableExtra<MyData>(DetailActivity.EXTRA_MYDATA)
    inline fun <reified T : Parcelable> Activity.getParcelableExtra(key: String) = lazy {
        intent.getParcelableExtra<T>(key)
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}