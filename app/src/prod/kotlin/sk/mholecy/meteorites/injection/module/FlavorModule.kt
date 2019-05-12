package sk.mholecy.meteorites.injection.module

import dagger.Module
import dagger.Provides
import okhttp3.HttpUrl
import sk.mholecy.meteorites.common.di.retention.ApiUrl
import javax.inject.Singleton

@Module
class FlavorModule {

    @Provides
    @Singleton
    @ApiUrl
    fun httpUrl(): HttpUrl = HttpUrl.get("https://data.nasa.gov")
}
