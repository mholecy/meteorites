package sk.mholecy.meteorites.meteorites.ui.list

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import sk.mholecy.meteorites.common.extensions.isOnline
import sk.mholecy.meteorites.meteorites.database.dao.MeteoritesDao
import sk.mholecy.meteorites.meteorites.service.MeteoritesDatabaseSyncService

class MeteoritesListViewModel(
    private val meteoritesService: MeteoritesDatabaseSyncService,
    private val context: Context,
    meteoritesDao: MeteoritesDao
) : ViewModel() {
    val meteorites = meteoritesService.meteorites
    val meteoritesCount = meteoritesDao.getMeteoritesCount()

    fun fetchMeteorites() {
        if (context.isOnline()) {
            viewModelScope.launch {
                meteoritesService.updateDbData()
            }
        }
    }
}
