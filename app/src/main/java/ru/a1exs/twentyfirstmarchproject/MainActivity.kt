package ru.a1exs.twentyfirstmarchproject

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.os.StrictMode
import android.os.StrictMode.ThreadPolicy
import androidx.appcompat.app.AppCompatActivity
import org.osmdroid.bonuspack.routing.OSRMRoadManager
import org.osmdroid.bonuspack.routing.Road
import org.osmdroid.bonuspack.routing.RoadManager
import org.osmdroid.config.Configuration
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.overlay.Marker
import ru.a1exs.twentyfirstmarchproject.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val startGeoPoint = GeoPoint(55.801139, 49.177280)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Configuration.getInstance()
            .load(this, baseContext.getSharedPreferences("ws", Context.MODE_PRIVATE))
        Configuration.getInstance().userAgentValue = "MyUserAgent"

        binding.mapView.setTileSource(TileSourceFactory.MAPNIK)

        val mapController = binding.mapView.controller

        binding.mapView.setMultiTouchControls(true)

        mapController.setZoom(18)

        mapController.setCenter(startGeoPoint)

        val marker = Marker(binding.mapView)

        marker.position = startGeoPoint

        binding.mapView.overlays.add(marker)

        val geoPointsArray = arrayListOf(
            startGeoPoint,
            GeoPoint(55.559273, 49.068407)
        )

        val policy = ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)

        val roadManager: RoadManager = OSRMRoadManager(this, "MyUserAgen")
        val road: Road = roadManager.getRoad(geoPointsArray)
        val roadOverlay = RoadManager.buildRoadOverlay(road)
        roadOverlay.outlinePaint.apply {
            strokeWidth = 16f
            color = Color.RED
        }


        binding.mapView.overlays.add(roadOverlay)

    }
}