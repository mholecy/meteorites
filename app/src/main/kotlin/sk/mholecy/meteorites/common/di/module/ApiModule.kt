package sk.mholecy.meteorites.common.di.module

import android.content.Context
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import sk.mholecy.meteorites.R
import sk.mholecy.meteorites.common.di.retention.ApiUrl
import sk.mholecy.meteorites.common.di.retention.ApplicationContext
import sk.mholecy.meteorites.meteorites.api.ApiKeyInterceptor
import sk.mholecy.meteorites.meteorites.api.MeteoritesApiClient
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class ApiModule {

    @Singleton
    @Provides
    fun provideApiKeyInterceptor(@ApplicationContext context: Context): ApiKeyInterceptor {
        return ApiKeyInterceptor(context.getString(R.string.nasa_api_token))
    }

    @Singleton
    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return httpLoggingInterceptor
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(
        loggingInterceptor: HttpLoggingInterceptor,
        apiKeyInterceptor: ApiKeyInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(apiKeyInterceptor)
            .addInterceptor(loggingInterceptor)
            .readTimeout(60, TimeUnit.SECONDS)
            .build()
    }

    @Singleton
    @Provides
    fun provideMoshiConverterFactory(): MoshiConverterFactory {
        val moshi = Moshi.Builder().build()
        return MoshiConverterFactory.create(moshi)
    }

    @Singleton
    @Provides
    fun provideRetrofit(
        @ApiUrl apiBaseUrl: HttpUrl,
        moshiConverterFactory: MoshiConverterFactory,
        okHttpClient: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(moshiConverterFactory)
            .baseUrl(apiBaseUrl)
            .client(okHttpClient)
            .build()
    }

    @Singleton
    @Provides
    fun provideApiClient(retrofit: Retrofit): MeteoritesApiClient {
        return retrofit.create(MeteoritesApiClient::class.java)
    }
}