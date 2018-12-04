package sk.mholecy.meteorites.meteorites.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import sk.mholecy.meteorites.databinding.FragmentMeteoritesListBinding
import sk.mholecy.meteorites.meteorites.ui.list.adapter.MeteoritesAdapter

class MeteoritesListFragment : Fragment() {
    companion object {
        fun newInstance() = MeteoritesListFragment()
    }

    private val meteoritesViewModel: MeteoritesListViewModel by viewModel()
    private val meteoritesListAdapter: MeteoritesAdapter by inject()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentMeteoritesListBinding.inflate(inflater, container, false)
        binding.meteoritesList.adapter = meteoritesListAdapter
        subscribeUi()
        return binding.root
    }

    private fun subscribeUi() {
        meteoritesViewModel.meteorites.observe(viewLifecycleOwner, Observer { meteorites ->
            meteoritesListAdapter.submitList(meteorites)
        })
        meteoritesViewModel.fetchMeteorites()
    }
}
