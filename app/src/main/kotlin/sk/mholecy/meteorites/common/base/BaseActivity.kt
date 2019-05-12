package sk.mholecy.meteorites.common.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import dagger.android.support.DaggerAppCompatActivity
import sk.mholecy.meteorites.common.di.AppViewModelFactory
import javax.inject.Inject
import kotlin.reflect.KClass

open class BaseActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var appViewModelFactory: AppViewModelFactory

    fun <VM : ViewModel> getViewModel(viewModelClass: KClass<VM>): VM =
        ViewModelProviders.of(this, appViewModelFactory)[viewModelClass.java]
}