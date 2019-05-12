package sk.mholecy.meteorites.common.worker

import android.content.Context
import androidx.work.ListenableWorker
import androidx.work.Worker
import androidx.work.WorkerParameters
import sk.mholecy.meteorites.common.base.ChildWorkerFactory
import sk.mholecy.meteorites.common.extensions.isOnline
import sk.mholecy.meteorites.meteorites.service.MeteoritesDatabaseSyncService
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Provider

class UpdateDatabaseWorker(
    private val context: Context,
    workerParams: WorkerParameters,
    private val updateDbService: MeteoritesDatabaseSyncService
) : Worker(context, workerParams) {

    override fun doWork(): Result {
        Timber.d("Executing periodic database sync")
        return if (context.isOnline()) {
            val isSuccess = updateDbService.updateDbData()
            if (isSuccess) {
                Result.success()
            } else {
                Result.retry()
            }
        } else {
            Result.retry()
        }
    }

    class Factory @Inject constructor(
        private val meteoritesDatabaseSyncService: Provider<MeteoritesDatabaseSyncService>
    ) : ChildWorkerFactory {
        override fun create(appContext: Context, params: WorkerParameters): ListenableWorker {
            return UpdateDatabaseWorker(
                appContext,
                params,
                meteoritesDatabaseSyncService.get()
            )
        }
    }
}
