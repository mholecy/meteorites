package sk.mholecy.meteorites.common.di.module

import android.content.Context
import androidx.room.Room
import androidx.work.WorkManager
import dagger.Module
import dagger.Provides
import sk.mholecy.meteorites.common.database.Database
import sk.mholecy.meteorites.common.database.DatabaseCallback
import sk.mholecy.meteorites.common.di.retention.ApplicationContext
import sk.mholecy.meteorites.meteorites.database.dao.MeteoritesDao
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabaseCallback(workManager: WorkManager): DatabaseCallback {
        return DatabaseCallback(workManager)
    }

    @Singleton
    @Provides
    fun provideRoom(
        @ApplicationContext context: Context,
        databaseCallback: DatabaseCallback
    ): Database {
        return Room.databaseBuilder(context, Database::class.java, "meteorites-db")
            .addCallback(databaseCallback)
            .build()
    }

    @Singleton
    @Provides
    fun provideMeteoritesDao(database: Database): MeteoritesDao = database.meteoritesDao()
}