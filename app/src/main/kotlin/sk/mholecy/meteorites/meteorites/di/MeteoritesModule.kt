package sk.mholecy.meteorites.meteorites.di

import dagger.Module
import dagger.Provides
import sk.mholecy.meteorites.common.database.Database
import sk.mholecy.meteorites.common.di.module.ApiModule
import sk.mholecy.meteorites.meteorites.api.MeteoritesApiClient
import sk.mholecy.meteorites.meteorites.database.converter.MeteoritesConverter
import sk.mholecy.meteorites.meteorites.database.dao.MeteoritesDao
import sk.mholecy.meteorites.meteorites.service.MeteoritesDatabaseSyncService
import javax.inject.Singleton

@Module(includes = [ApiModule::class])
class MeteoritesModule {

    @Singleton
    @Provides
    fun provideMeteoritesDatabaseSyncService(
        apiClient: MeteoritesApiClient,
        meteoritesDao: MeteoritesDao,
        meteoritesConverter: MeteoritesConverter
    ): MeteoritesDatabaseSyncService = MeteoritesDatabaseSyncService(apiClient, meteoritesDao, meteoritesConverter)

    @Singleton
    @Provides
    fun provideMeteoritesDao(database: Database): MeteoritesDao = database.meteoritesDao()

    @Singleton
    @Provides
    fun provideMeteoritesConverter() = MeteoritesConverter()
}
