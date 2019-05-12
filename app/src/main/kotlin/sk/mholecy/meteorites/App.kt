package sk.mholecy.meteorites

import androidx.work.Configuration
import androidx.work.WorkManager
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import sk.mholecy.meteorites.common.di.AppWorkerFactory
import sk.mholecy.meteorites.common.di.DaggerAppComponent
import javax.inject.Inject

class App : DaggerApplication() {

    @Inject
    lateinit var appWorkerFactory: AppWorkerFactory

    override fun onCreate() {
        super.onCreate()
        WorkManager.initialize(
            this,
            Configuration.Builder()
                .setWorkerFactory(appWorkerFactory)
                .build()
        )
    }

    override fun applicationInjector(): AndroidInjector<out App> = DaggerAppComponent
        .factory()
        .create(this)
}
