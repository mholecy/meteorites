package sk.mholecy.meteorites.common.database

import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.PeriodicWorkRequest
import androidx.work.WorkManager
import sk.mholecy.meteorites.common.worker.UpdateDatabaseWorker
import java.util.concurrent.TimeUnit

class DatabaseCallback(
    private val workManager: WorkManager
) : RoomDatabase.Callback() {
    override fun onCreate(db: SupportSQLiteDatabase) {
        super.onCreate(db)
        val request = PeriodicWorkRequest.Builder(
            UpdateDatabaseWorker::class.java,
            1,
            TimeUnit.DAYS
        ).setConstraints(
            Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build()
        ).build()
        workManager.enqueue(request)
    }
}
