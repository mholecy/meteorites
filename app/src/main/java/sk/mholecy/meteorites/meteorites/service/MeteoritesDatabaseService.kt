package sk.mholecy.meteorites.meteorites.service

import sk.mholecy.meteorites.meteorites.api.MeteoritesApiClient
import sk.mholecy.meteorites.meteorites.api.model.ApiMeteoriteModel
import sk.mholecy.meteorites.meteorites.database.converter.MeteoritesConverter
import sk.mholecy.meteorites.meteorites.database.dao.MeteoritesDao

class MeteoritesDatabaseService(
    private val meteoritesApiClient: MeteoritesApiClient,
    private val meteoritesDao: MeteoritesDao,
    private val meteoritesConverter: MeteoritesConverter
) {
    val meteorites = meteoritesDao.getMeteorites()

    fun updateDbData() {
        val maxDbId = meteoritesDao.getMaxId()?.id
        val apiWhereCondition = if (maxDbId == null) {
            "year>=\"2011-01-01T00:00:00.000\""
        } else {
            "year>=\"2011-01-01T00:00:00.000\" AND id>\"$maxDbId\""
        }
        val meteoritesToInsert = getMeteoritesFromApi(apiWhereCondition)
        meteoritesToInsert.forEach { apiMeteoriteModel ->
            meteoritesDao.insert(meteoritesConverter.convertToDbObject(apiMeteoriteModel))
        }
    }

    private fun getMeteoritesFromApi(whereCondition: String): List<ApiMeteoriteModel> {
        val request = meteoritesApiClient.getMeteoritesData(whereCondition)
        val response = request.execute()
        return if (response.isSuccessful) {
            response.body() ?: emptyList()
        } else {
            emptyList()
        }
    }
}
