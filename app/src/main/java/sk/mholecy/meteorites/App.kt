package sk.mholecy.meteorites

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import sk.mholecy.meteorites.common.di.DaggerAppComponent

class App : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out App> = DaggerAppComponent
        .factory()
        .create(this)
}
