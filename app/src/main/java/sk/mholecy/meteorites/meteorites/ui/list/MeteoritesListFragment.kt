package sk.mholecy.meteorites.meteorites.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.meteorites_list_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import sk.mholecy.meteorites.R

class MeteoritesListFragment : Fragment() {

    companion object {
        fun newInstance() = MeteoritesListFragment()
    }

    private val meteoritesViewModel: MeteoritesListViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.meteorites_list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        meteoritesViewModel.meteorites.observe(this, Observer { meteoritesList ->
            tv_message.text = meteoritesList.toString()
        })
        meteoritesViewModel.fetchMeteorites()
    }
}
