package sk.mholecy.meteorites.meteorites.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import org.koin.androidx.viewmodel.ext.viewModel
import sk.mholecy.meteorites.R
import sk.mholecy.meteorites.databinding.FragmentMeteoriteMapBinding

class MeteoriteMapFragment : Fragment(), OnMapReadyCallback {
    private val meteoriteMapViewModel: MeteoriteMapViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val meteoriteId = MeteoriteMapFragmentArgs.fromBundle(arguments!!).meteoriteId
        val meteoriteMapBinding = FragmentMeteoriteMapBinding.inflate(inflater, container, false)
        meteoriteMapBinding.apply {
            viewModel = meteoriteMapViewModel
            lifecycleOwner = this@MeteoriteMapFragment
            meteoriteMapViewModel.getMeteorite(meteoriteId)
        }
        return meteoriteMapBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.fragment_map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        meteoriteMapViewModel.meteorite.observe(viewLifecycleOwner, Observer {
            val position = LatLng(it.latitude, it.longitude)
            googleMap.addMarker(MarkerOptions().position(position).title(it.name))
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(position))
        })
    }
}
