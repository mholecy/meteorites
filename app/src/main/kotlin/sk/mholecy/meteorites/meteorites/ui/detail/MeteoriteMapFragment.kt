package sk.mholecy.meteorites.meteorites.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import sk.mholecy.meteorites.R
import sk.mholecy.meteorites.common.base.BaseFragment
import sk.mholecy.meteorites.databinding.FragmentMeteoriteMapBinding

class MeteoriteMapFragment : BaseFragment(), OnMapReadyCallback {

    private val viewModel: MeteoriteMapViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val meteoriteId = MeteoriteMapFragmentArgs.fromBundle(requireArguments()).meteoriteId
        viewModel.getMeteorite(meteoriteId)
        val meteoriteMapBinding = FragmentMeteoriteMapBinding.inflate(inflater, container, false)
        meteoriteMapBinding.apply {
            viewModel = viewModel
            lifecycleOwner = viewLifecycleOwner
        }
        return meteoriteMapBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment =
            childFragmentManager.findFragmentById(R.id.fragment_map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        viewModel.meteorite.observe(viewLifecycleOwner, Observer {
            val position = LatLng(it.latitude, it.longitude)
            googleMap.addMarker(MarkerOptions().position(position).title(it.name))
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(position))
        })
    }
}
