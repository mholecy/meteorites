package sk.mholecy.meteorites.meteorites.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import sk.mholecy.meteorites.meteorites.database.dao.MeteoritesDao
import sk.mholecy.meteorites.meteorites.database.model.DbMeteoriteModel

class MeteoriteMapViewModel(
    private val meteoritesDao: MeteoritesDao
) : ViewModel() {
    lateinit var meteorite: LiveData<DbMeteoriteModel>

    fun getMeteorite(meteoriteId: Long) {
        GlobalScope.launch {
            meteorite = meteoritesDao.getMeteorite(meteoriteId)
        }
    }
}
