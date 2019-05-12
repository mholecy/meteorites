package sk.mholecy.meteorites.common.di.module.android

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import sk.mholecy.meteorites.common.di.AppViewModelFactory
import sk.mholecy.meteorites.common.di.retention.ViewModelKey
import sk.mholecy.meteorites.meteorites.ui.detail.MeteoriteMapViewModel
import sk.mholecy.meteorites.meteorites.ui.list.MeteoritesListViewModel

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindAppViewModelFactory(appViewModelFactory: AppViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MeteoriteMapViewModel::class)
    internal abstract fun bindMeteoriteMapViewModel(viewModel: MeteoriteMapViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MeteoritesListViewModel::class)
    internal abstract fun bindMeteoritesListViewModel(viewModel: MeteoritesListViewModel): ViewModel
}