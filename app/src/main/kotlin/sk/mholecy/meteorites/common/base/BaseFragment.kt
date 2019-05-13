package sk.mholecy.meteorites.common.base

import androidx.lifecycle.ViewModelProviders
import dagger.android.support.DaggerFragment
import sk.mholecy.meteorites.common.di.AppViewModelFactory
import javax.inject.Inject
import kotlin.reflect.KClass

open class BaseFragment : DaggerFragment() {

    @Inject
    lateinit var appViewModelFactory: AppViewModelFactory

    fun <VM : BaseViewModel> getViewModel(viewModelClass: KClass<VM>): VM =
        ViewModelProviders.of(this, appViewModelFactory)[viewModelClass.java].apply {
            lifecycle.addObserver(this)
        }
}