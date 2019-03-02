package sk.mholecy.meteorites.common.di

import kotlinx.coroutines.SupervisorJob
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import sk.mholecy.meteorites.meteorites.database.dao.MeteoritesDao
import sk.mholecy.meteorites.meteorites.service.MeteoritesDatabaseSyncService
import sk.mholecy.meteorites.meteorites.ui.detail.MeteoriteMapViewModel
import sk.mholecy.meteorites.meteorites.ui.list.MeteoritesListViewModel

internal val viewModelModule = module {
    viewModel {
        MeteoritesListViewModel(
            get<MeteoritesDatabaseSyncService>(),
            androidApplication(),
            get<MeteoritesDao>()
        )
    }
    viewModel {
        MeteoriteMapViewModel(
            get<MeteoritesDao>()
        )
    }

    factory {
        SupervisorJob()
    }
}
