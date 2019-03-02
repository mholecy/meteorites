package sk.mholecy.meteorites.common.viewModel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import org.koin.core.KoinComponent
import org.koin.core.inject
import kotlin.coroutines.CoroutineContext

open class ScopedViewModel : ViewModel(), CoroutineScope, KoinComponent {
    private val job: Job by inject()

    override val coroutineContext: CoroutineContext = job + Dispatchers.Default

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
}
