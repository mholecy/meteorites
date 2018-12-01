package sk.mholecy.meteorites.meteorites.di

import org.koin.dsl.module.module
import sk.mholecy.meteorites.meteorites.api.MeteoritesApiClient
import sk.mholecy.meteorites.meteorites.service.MeteoritesListService

internal val meteoritesModule = module {
    single {
        MeteoritesListService(get<MeteoritesApiClient>())
    }
}
