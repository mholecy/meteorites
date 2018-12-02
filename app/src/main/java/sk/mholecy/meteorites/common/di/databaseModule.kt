package sk.mholecy.meteorites.common.di

import androidx.room.Room
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module.module
import sk.mholecy.meteorites.common.database.Database

internal val databaseModule = module {
    single {
        Room.databaseBuilder(
            androidApplication(),
            Database::class.java,
            "meteorites-db"
        ).build()
    }
}
