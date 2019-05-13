package sk.mholecy.meteorites.meteorites.ui.list

import android.content.Context
import kotlinx.coroutines.launch
import sk.mholecy.meteorites.common.base.ScopedViewModel
import sk.mholecy.meteorites.common.di.retention.ApplicationContext
import sk.mholecy.meteorites.common.extensions.isOnline
import sk.mholecy.meteorites.meteorites.database.dao.MeteoritesDao
import sk.mholecy.meteorites.meteorites.service.MeteoritesDatabaseSyncService
import javax.inject.Inject

class MeteoritesListViewModel @Inject constructor(
    @ApplicationContext private val context: Context,
    private val meteoritesService: MeteoritesDatabaseSyncService,
    meteoritesDao: MeteoritesDao
) : ScopedViewModel() {
    val meteorites = meteoritesService.meteorites
    val meteoritesCount = meteoritesDao.getMeteoritesCount()

    override fun onStart() {
        if (context.isOnline()) {
            launch {
                meteoritesService.updateDbData()
            }
        }
    }
}
