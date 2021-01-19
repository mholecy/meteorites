package sk.mholecy.meteorites.meteorites.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import sk.mholecy.meteorites.common.base.BaseViewModel
import sk.mholecy.meteorites.meteorites.database.dao.MeteoritesDao
import sk.mholecy.meteorites.meteorites.database.model.DbMeteoriteModel
import javax.inject.Inject

class MeteoriteMapViewModel @Inject constructor(
    private val meteoritesDao: MeteoritesDao
) : BaseViewModel() {
    lateinit var meteorite: LiveData<DbMeteoriteModel>

    fun getMeteorite(meteoriteId: Long) {
        meteorite = meteoritesDao
            .getMeteorite(meteoriteId)
            .asLiveData(viewModelScope.coroutineContext)
    }
}
