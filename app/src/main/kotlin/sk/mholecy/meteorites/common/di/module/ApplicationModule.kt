package sk.mholecy.meteorites.common.di.module

import android.content.Context
import android.content.res.Resources
import androidx.work.WorkManager
import dagger.Module
import dagger.Provides
import sk.mholecy.meteorites.App
import sk.mholecy.meteorites.common.di.retention.ApplicationContext
import javax.inject.Singleton

@Module
class ApplicationModule {

    @Provides
    @ApplicationContext
    fun provideContext(app: App): Context = app

    @Singleton
    @Provides
    fun provideResources(@ApplicationContext context: Context): Resources = context.resources

    @Singleton
    @Provides
    fun provideWorkManager(@ApplicationContext context: Context) = WorkManager.getInstance(context)
}