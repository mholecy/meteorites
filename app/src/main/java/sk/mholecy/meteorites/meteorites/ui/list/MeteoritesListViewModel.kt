package sk.mholecy.meteorites.meteorites.ui.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import sk.mholecy.meteorites.meteorites.api.model.ApiMeteoriteModel
import sk.mholecy.meteorites.meteorites.service.MeteoritesListService

class MeteoritesListViewModel(
    private val meteoritesService: MeteoritesListService
) : ViewModel() {
    val meteorites = MutableLiveData<List<ApiMeteoriteModel>>()

    fun fetchMeteorites() {
        GlobalScope.launch {
            meteorites.postValue(meteoritesService.getMeteoritesFromApi())
        }
    }
}
