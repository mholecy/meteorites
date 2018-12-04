package sk.mholecy.meteorites.common.di

import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module
import sk.mholecy.meteorites.meteorites.service.MeteoritesDatabaseSyncService
import sk.mholecy.meteorites.meteorites.ui.list.MeteoritesListViewModel

internal val viewModelModule = module {
    viewModel {
        MeteoritesListViewModel(
            get<MeteoritesDatabaseSyncService>(),
            androidApplication()
        )
    }
}
