package sk.mholecy.meteorites.common.di

import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module
import sk.mholecy.meteorites.meteorites.service.MeteoritesListService
import sk.mholecy.meteorites.meteorites.ui.list.MeteoritesListViewModel

internal val viewModelModule = module {
    viewModel {
        MeteoritesListViewModel(get<MeteoritesListService>())
    }
}
