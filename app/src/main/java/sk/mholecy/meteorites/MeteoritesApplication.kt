package sk.mholecy.meteorites

import android.app.Application
import org.koin.android.ext.android.startKoin
import sk.mholecy.meteorites.common.di.apiModule
import sk.mholecy.meteorites.common.di.databaseModule
import sk.mholecy.meteorites.common.di.viewModelModule
import sk.mholecy.meteorites.meteorites.di.meteoritesModule

class MeteoritesApplication : Application() {
    companion object {
        const val API_TOKEN = "api_token"
        const val NASA_API_URL = "nasa_api_url"
    }

    override fun onCreate() {
        super.onCreate()
        startKoin(
            this,
            modules = listOf(
                apiModule,
                databaseModule,
                meteoritesModule,
                viewModelModule
            ),
            extraProperties = mapOf(
                API_TOKEN to getString(R.string.nasa_api_token),
                NASA_API_URL to "https://data.nasa.gov"
            )
        )
    }
}