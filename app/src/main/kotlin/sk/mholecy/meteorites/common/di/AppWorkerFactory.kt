package sk.mholecy.meteorites.common.di

import android.content.Context
import androidx.work.ListenableWorker
import androidx.work.WorkerFactory
import androidx.work.WorkerParameters
import sk.mholecy.meteorites.common.base.ChildWorkerFactory
import javax.inject.Inject
import javax.inject.Provider

class AppWorkerFactory @Inject constructor(
    private val workerFactories: Map<Class<out ListenableWorker>, @JvmSuppressWildcards Provider<ChildWorkerFactory>>
) : WorkerFactory() {
    override fun createWorker(
        appContext: Context,
        workerClassName: String,
        workerParameters: WorkerParameters
    ): ListenableWorker? {
        val foundEntry = workerFactories.entries.find {
            Class.forName(workerClassName).isAssignableFrom(it.key)
        }
        val factoryProvider = foundEntry?.value
            ?: error("Unknown worker class name: $workerClassName")
        return factoryProvider.get().create(appContext, workerParameters)
    }
}