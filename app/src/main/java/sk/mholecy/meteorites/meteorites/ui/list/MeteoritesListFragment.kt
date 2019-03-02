package sk.mholecy.meteorites.meteorites.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.google.android.material.snackbar.Snackbar
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.viewModel
import sk.mholecy.meteorites.R
import sk.mholecy.meteorites.common.extensions.setActionTextColorId
import sk.mholecy.meteorites.common.extensions.setBackgroundColor
import sk.mholecy.meteorites.databinding.FragmentMeteoritesListBinding
import sk.mholecy.meteorites.meteorites.ui.list.adapter.MeteoritesAdapter

class MeteoritesListFragment : Fragment() {
    private val meteoritesViewModel: MeteoritesListViewModel by viewModel()
    private val meteoritesListAdapter: MeteoritesAdapter by inject()
    private lateinit var rootView: View
    private var meteoriteCountSnackBar: Snackbar? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentMeteoritesListBinding.inflate(inflater, container, false)
        val activity = activity as AppCompatActivity
        activity.setSupportActionBar(binding.toolbar)
        binding.meteoritesList.adapter = meteoritesListAdapter
        setHasOptionsMenu(true)
        subscribeUi()
        rootView = binding.root
        return rootView
    }

    private fun subscribeUi() {
        meteoritesViewModel.meteorites.observe(viewLifecycleOwner, Observer { meteorites ->
            meteoritesListAdapter.submitList(meteorites)
        })
        meteoritesViewModel.meteoritesCount.observe(viewLifecycleOwner, Observer {
            meteoriteCountSnackBar?.setText(
                String.format(getString(R.string.meteorites_count_message), it)
            )
        })
        meteoritesViewModel.fetchMeteorites()
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.action_show_meteorites_count -> {
            createMeteoriteCountSnackBar()
            true
        }
        else -> {
            super.onOptionsItemSelected(item)
        }
    }

    private fun createMeteoriteCountSnackBar() {
        meteoriteCountSnackBar = Snackbar.make(
            rootView,
            String.format(getString(R.string.meteorites_count_message), meteoritesViewModel.meteoritesCount.value),
            Snackbar.LENGTH_INDEFINITE
        )
        meteoriteCountSnackBar?.apply {
            setAction(getString(R.string.snackbar_acknowledge)) {
                dismiss()
            }
            setBackgroundColor(R.color.primaryLightColor)
            setActionTextColorId(R.color.secondaryLightColor)
            show()
        }
    }
}
