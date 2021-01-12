package sk.mholecy.meteorites.meteorites.service

import androidx.paging.LivePagedListBuilder
import kotlinx.coroutines.flow.first
import retrofit2.HttpException
import sk.mholecy.meteorites.meteorites.api.MeteoritesApiClient
import sk.mholecy.meteorites.meteorites.api.model.ApiMeteoriteModel
import sk.mholecy.meteorites.meteorites.database.dao.MeteoritesDao
import sk.mholecy.meteorites.meteorites.database.model.DbMeteoriteModel
import javax.inject.Inject

class MeteoritesDatabaseSyncService @Inject constructor(
    private val meteoritesApiClient: MeteoritesApiClient,
    private val meteoritesDao: MeteoritesDao
) {
    val meteorites = LivePagedListBuilder(meteoritesDao.getMeteoritesPaged(), 20).build()

    suspend fun updateDbData(): Boolean {
        val maxDbId = meteoritesDao.getMaxId().first()?.id
        val apiWhereCondition = if (maxDbId == null) {
            "year>=\"2011-01-01T00:00:00.000\""
        } else {
            "year>=\"2011-01-01T00:00:00.000\" AND id>\"$maxDbId\""
        }

        return try {
            val meteoritesToInsert = meteoritesApiClient
                .getMeteoritesData(apiWhereCondition)
                .map { apiMeteoriteModel -> apiMeteoriteModel.convertToDbObject() }
            meteoritesDao.insertAll(meteoritesToInsert)
            true
        } catch (httpException: HttpException) {
            httpException.printStackTrace()
            false
        }
    }

    private fun ApiMeteoriteModel.convertToDbObject(): DbMeteoriteModel {
        return DbMeteoriteModel(
            id = id,
            fall = fall,
            type = type,
            mass = mass,
            name = name,
            nameType = nametype,
            recClass = recclass,
            latitude = reclat,
            longitude = reclong,
            year = year.substring(0, 4).toInt()
        )
    }
}
