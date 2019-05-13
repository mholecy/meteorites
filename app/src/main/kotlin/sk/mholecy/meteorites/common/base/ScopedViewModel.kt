package sk.mholecy.meteorites.common.base

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlin.coroutines.CoroutineContext

open class ScopedViewModel : BaseViewModel(), CoroutineScope {
    private val job = SupervisorJob()

    override val coroutineContext: CoroutineContext = job + Dispatchers.Default

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
}
