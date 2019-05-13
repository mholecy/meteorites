package sk.mholecy.meteorites.meteorites.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.google.android.material.snackbar.Snackbar
import sk.mholecy.meteorites.R
import sk.mholecy.meteorites.common.base.BaseFragment
import sk.mholecy.meteorites.common.extensions.setActionTextColorId
import sk.mholecy.meteorites.common.extensions.setBackgroundColor
import sk.mholecy.meteorites.databinding.FragmentMeteoritesListBinding
import sk.mholecy.meteorites.meteorites.ui.list.adapter.MeteoritesAdapter
import javax.inject.Inject

class MeteoritesListFragment : BaseFragment() {
    @Inject
    lateinit var meteoritesListAdapter: MeteoritesAdapter
    private lateinit var rootView: View
    private var meteoriteCountSnackBar: Snackbar? = null

    private val viewModel by lazy {
        getViewModel(MeteoritesListViewModel::class)
    }

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
        viewModel.meteorites.observe(viewLifecycleOwner, Observer { meteorites ->
            meteoritesListAdapter.submitList(meteorites)
        })
        viewModel.meteoritesCount.observe(viewLifecycleOwner, Observer {
            meteoriteCountSnackBar?.setText(
                String.format(getString(R.string.meteorites_count_message), it)
            )
        })
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
            String.format(getString(R.string.meteorites_count_message), viewModel.meteoritesCount.value),
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
