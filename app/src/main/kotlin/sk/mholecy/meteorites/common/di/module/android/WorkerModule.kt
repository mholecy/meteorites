package sk.mholecy.meteorites.common.di.module.android

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import sk.mholecy.meteorites.common.base.ChildWorkerFactory
import sk.mholecy.meteorites.common.di.retention.WorkerKey
import sk.mholecy.meteorites.common.worker.UpdateDatabaseWorker

@Module
abstract class WorkerModule {

    @Binds
    @IntoMap
    @WorkerKey(UpdateDatabaseWorker::class)
    abstract fun bindUpdateDatabaseWorker(factory: UpdateDatabaseWorker.Factory): ChildWorkerFactory
}