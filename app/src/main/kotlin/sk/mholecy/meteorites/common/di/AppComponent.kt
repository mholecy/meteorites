package sk.mholecy.meteorites.common.di

import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import sk.mholecy.meteorites.App
import sk.mholecy.meteorites.common.di.module.ApiModule
import sk.mholecy.meteorites.common.di.module.ApplicationModule
import sk.mholecy.meteorites.common.di.module.DatabaseModule
import sk.mholecy.meteorites.common.di.module.android.ActivityBuilderModule
import sk.mholecy.meteorites.common.di.module.android.FragmentBuilderModule
import sk.mholecy.meteorites.common.di.module.android.ViewModelModule
import sk.mholecy.meteorites.common.di.module.android.WorkerModule
import sk.mholecy.meteorites.injection.module.FlavorModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ActivityBuilderModule::class,
        AndroidInjectionModule::class,
        AndroidSupportInjectionModule::class,
        ApiModule::class,
        ApplicationModule::class,
        DatabaseModule::class,
        FlavorModule::class,
        FragmentBuilderModule::class,
        ViewModelModule::class,
        WorkerModule::class
    ]
)
interface AppComponent : AndroidInjector<App> {

    @Component.Factory
    interface Factory : AndroidInjector.Factory<App>
}
