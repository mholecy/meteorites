package sk.mholecy.meteorites.common.worker

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject
import sk.mholecy.meteorites.common.extensions.isOnline
import sk.mholecy.meteorites.meteorites.service.MeteoritesDatabaseSyncService

class UpdateDatabaseWorker(
    private val context: Context,
    workerParams: WorkerParameters
) : Worker(context, workerParams), KoinComponent {
    private val TAG by lazy { UpdateDatabaseWorker::class.java.simpleName }
    private val updateDbService: MeteoritesDatabaseSyncService by inject()

    override fun doWork(): Result {
        Log.i(TAG, "Executing periodic database sync")
        return if (context.isOnline()) {
            val isSuccess = updateDbService.updateDbData()
            if (isSuccess) {
                Result.SUCCESS
            } else {
                Result.RETRY
            }
        } else {
            Result.RETRY
        }
    }
}
