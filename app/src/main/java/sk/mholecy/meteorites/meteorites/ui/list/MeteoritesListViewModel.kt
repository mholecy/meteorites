package sk.mholecy.meteorites.meteorites.ui.list

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import sk.mholecy.meteorites.meteorites.service.MeteoritesDatabaseService

class MeteoritesListViewModel(
    private val meteoritesService: MeteoritesDatabaseService
) : ViewModel() {
    val meteorites = meteoritesService.meteorites

    fun fetchMeteorites() {
        GlobalScope.launch {
            meteoritesService.updateDbData()
        }
    }
}
