package sk.mholecy.meteorites.meteorites.di

import org.koin.dsl.module.module
import sk.mholecy.meteorites.common.database.Database
import sk.mholecy.meteorites.meteorites.api.MeteoritesApiClient
import sk.mholecy.meteorites.meteorites.database.converter.MeteoritesConverter
import sk.mholecy.meteorites.meteorites.database.dao.MeteoritesDao
import sk.mholecy.meteorites.meteorites.service.MeteoritesDatabaseService

internal val meteoritesModule = module {
    single {
        MeteoritesDatabaseService(
            get<MeteoritesApiClient>(),
            get<MeteoritesDao>(),
            get<MeteoritesConverter>()
        )
    }
    single {
        get<Database>().meteoritesDao()
    }
    single {
        MeteoritesConverter()
    }
}
