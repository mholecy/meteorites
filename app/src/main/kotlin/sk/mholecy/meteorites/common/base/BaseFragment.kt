package sk.mholecy.meteorites.common.base

import androidx.fragment.app.viewModels
import dagger.android.support.DaggerFragment
import sk.mholecy.meteorites.common.di.AppViewModelFactory
import javax.inject.Inject

open class BaseFragment : DaggerFragment() {

    @Inject
    lateinit var appViewModelFactory: AppViewModelFactory

    inline fun <reified VM : BaseViewModel> viewModel(): Lazy<VM> = lazy {
        val viewModel: VM by viewModels { appViewModelFactory }
        viewModel.apply {
            lifecycle.addObserver(this)
        }
    }
}
