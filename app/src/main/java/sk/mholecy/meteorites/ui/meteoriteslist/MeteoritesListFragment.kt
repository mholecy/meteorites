package sk.mholecy.meteorites.ui.meteoriteslist

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import sk.mholecy.meteorites.R

class MeteoritesListFragment : Fragment() {

    companion object {
        fun newInstance() = MeteoritesListFragment()
    }

    private lateinit var viewModel: MeteoritesListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.meteorites_list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MeteoritesListViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
