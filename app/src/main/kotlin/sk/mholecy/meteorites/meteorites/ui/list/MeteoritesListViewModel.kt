package sk.mholecy.meteorites.meteorites.ui.list

import android.content.Context
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import sk.mholecy.meteorites.common.base.BaseViewModel
import sk.mholecy.meteorites.common.di.retention.ApplicationContext
import sk.mholecy.meteorites.common.extensions.isOnline
import sk.mholecy.meteorites.meteorites.database.dao.MeteoritesDao
import sk.mholecy.meteorites.meteorites.service.MeteoritesDatabaseSyncService
import javax.inject.Inject

class MeteoritesListViewModel @Inject constructor(
    @ApplicationContext private val context: Context,
    private val meteoritesService: MeteoritesDatabaseSyncService,
    meteoritesDao: MeteoritesDao
) : BaseViewModel() {
    val meteorites = meteoritesService.meteorites
    val meteoritesCount = meteoritesDao.getMeteoritesCount().asLiveData()

    override fun onStart() {
        if (context.isOnline()) {
            viewModelScope.launch {
                meteoritesService.updateDbData()
            }
        }
    }
}
