package sk.mholecy.meteorites.meteorites.ui.list

import android.content.Context
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import sk.mholecy.meteorites.common.extensions.isOnline
import sk.mholecy.meteorites.meteorites.service.MeteoritesDatabaseSyncService

class MeteoritesListViewModel(
    private val meteoritesService: MeteoritesDatabaseSyncService,
    private val context: Context
) : ViewModel() {
    val meteorites = meteoritesService.meteorites

    fun fetchMeteorites() {
        if (context.isOnline()) {
            GlobalScope.launch {
                meteoritesService.updateDbData()
            }
        }
    }
}
