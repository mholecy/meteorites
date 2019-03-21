package sk.mholecy.meteorites.meteorites.ui.detail

import androidx.lifecycle.LiveData
import kotlinx.coroutines.launch
import sk.mholecy.meteorites.common.base.ScopedViewModel
import sk.mholecy.meteorites.meteorites.database.dao.MeteoritesDao
import sk.mholecy.meteorites.meteorites.database.model.DbMeteoriteModel
import javax.inject.Inject

class MeteoriteMapViewModel @Inject constructor(
    private val meteoritesDao: MeteoritesDao
) : ScopedViewModel() {
    lateinit var meteorite: LiveData<DbMeteoriteModel>

    fun getMeteorite(meteoriteId: Long) {
        launch {
            meteorite = meteoritesDao.getMeteorite(meteoriteId)
        }
    }
}
