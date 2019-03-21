package sk.mholecy.meteorites.common.di.module.android

import dagger.Module
import dagger.android.ContributesAndroidInjector
import sk.mholecy.meteorites.common.di.retention.ActivityScope
import sk.mholecy.meteorites.meteorites.ui.main.MainActivity

@Module
abstract class ActivityBuilderModule {

    @ActivityScope
    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity
}