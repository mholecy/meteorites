package sk.mholecy.meteorites.common.worker

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import sk.mholecy.meteorites.common.extensions.isOnline

class UpdateDatabaseWorker(
    private val context: Context,
    workerParams: WorkerParameters
) : Worker(context, workerParams) {

    // @Inject
    // lateinit var updateDbService: MeteoritesDatabaseSyncService

    private val TAG by lazy { UpdateDatabaseWorker::class.java.simpleName }

    override fun doWork(): Result {
        Log.i(TAG, "Executing periodic database sync")
        return if (context.isOnline()) {
            // val isSuccess = updateDbService.updateDbData()
            val isSuccess = true
            if (isSuccess) {
                Result.success()
            } else {
                Result.retry()
            }
        } else {
            Result.retry()
        }
    }
}
