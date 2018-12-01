package sk.mholecy.meteorites.common.di

import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import sk.mholecy.meteorites.MeteoritesApplication.Companion.API_TOKEN
import sk.mholecy.meteorites.MeteoritesApplication.Companion.NASA_API_URL
import sk.mholecy.meteorites.meteorites.api.ApiKeyInterceptor
import sk.mholecy.meteorites.meteorites.api.MeteoritesApiClient
import java.util.concurrent.TimeUnit

internal val apiModule = module {
    single {
        ApiKeyInterceptor(
            apiKey = getProperty(API_TOKEN)
        )
    }
    single {
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }
    single {
        OkHttpClient.Builder()
            .addInterceptor(get<ApiKeyInterceptor>())
            .addInterceptor(get<HttpLoggingInterceptor>())
            .readTimeout(60, TimeUnit.SECONDS)
            .build()
    }
    single {
        Moshi.Builder().build()
    }
    single {
        Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(get<Moshi>()).withNullSerialization())
            .baseUrl(getProperty<String>(NASA_API_URL))
            .client(get<OkHttpClient>())
            .build()
    }
    single {
        get<Retrofit>().create(MeteoritesApiClient::class.java)
    }
}
