package sk.mholecy.meteorites.common.di.module.android

import dagger.Module
import dagger.android.ContributesAndroidInjector
import sk.mholecy.meteorites.common.di.retention.FragmentScope
import sk.mholecy.meteorites.meteorites.ui.detail.MeteoriteMapFragment
import sk.mholecy.meteorites.meteorites.ui.list.MeteoritesListFragment

@Module
abstract class FragmentBuilderModule {

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun meteoriteMapFragment(): MeteoriteMapFragment

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun meteoritesListFragment(): MeteoritesListFragment
}