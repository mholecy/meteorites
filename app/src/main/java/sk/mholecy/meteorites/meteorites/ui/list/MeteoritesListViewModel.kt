package sk.mholecy.meteorites.meteorites.ui.list

import android.content.Context
import kotlinx.coroutines.launch
import sk.mholecy.meteorites.common.extensions.isOnline
import sk.mholecy.meteorites.common.viewModel.ScopedViewModel
import sk.mholecy.meteorites.meteorites.database.dao.MeteoritesDao
import sk.mholecy.meteorites.meteorites.service.MeteoritesDatabaseSyncService

class MeteoritesListViewModel(
    private val meteoritesService: MeteoritesDatabaseSyncService,
    private val context: Context,
    meteoritesDao: MeteoritesDao
) : ScopedViewModel() {
    val meteorites = meteoritesService.meteorites
    val meteoritesCount = meteoritesDao.getMeteoritesCount()

    fun fetchMeteorites() {
        if (context.isOnline()) {
            launch {
                meteoritesService.updateDbData()
            }
        }
    }
}
