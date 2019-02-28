package sk.mholecy.meteorites.common.di

import androidx.room.Room
import androidx.work.WorkManager
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module
import sk.mholecy.meteorites.common.database.Database
import sk.mholecy.meteorites.common.database.DatabaseCallback

internal val databaseModule = module {
    single {
        Room.databaseBuilder(androidApplication(), Database::class.java, "meteorites-db")
            .addCallback(get<DatabaseCallback>())
            .build()
    }
    single {
        DatabaseCallback(get<WorkManager>())
    }
    single {
        WorkManager.getInstance()
    }
}
