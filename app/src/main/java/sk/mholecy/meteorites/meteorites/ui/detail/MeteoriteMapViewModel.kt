package sk.mholecy.meteorites.meteorites.ui.detail

import androidx.lifecycle.LiveData
import kotlinx.coroutines.launch
import sk.mholecy.meteorites.common.viewModel.ScopedViewModel
import sk.mholecy.meteorites.meteorites.database.dao.MeteoritesDao
import sk.mholecy.meteorites.meteorites.database.model.DbMeteoriteModel

class MeteoriteMapViewModel(
    private val meteoritesDao: MeteoritesDao
) : ScopedViewModel() {
    lateinit var meteorite: LiveData<DbMeteoriteModel>

    fun getMeteorite(meteoriteId: Long) {
        launch {
            meteorite = meteoritesDao.getMeteorite(meteoriteId)
        }
    }
}
