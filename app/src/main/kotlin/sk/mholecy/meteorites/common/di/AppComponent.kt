package sk.mholecy.meteorites.common.di

import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import sk.mholecy.meteorites.App
import sk.mholecy.meteorites.common.di.module.ApplicationModule
import sk.mholecy.meteorites.common.di.module.DatabaseModule
import sk.mholecy.meteorites.common.di.module.android.ActivityBuilderModule
import sk.mholecy.meteorites.common.di.module.android.FragmentBuilderModule
import sk.mholecy.meteorites.common.di.module.android.ViewModelModule
import sk.mholecy.meteorites.meteorites.di.MeteoritesModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ActivityBuilderModule::class,
        AndroidInjectionModule::class,
        AndroidSupportInjectionModule::class,
        ApplicationModule::class,
        DatabaseModule::class,
        FragmentBuilderModule::class,
        ViewModelModule::class,
        MeteoritesModule::class
    ]
)
interface AppComponent : AndroidInjector<App> {

    @Component.Factory
    interface Factory : AndroidInjector.Factory<App>
}