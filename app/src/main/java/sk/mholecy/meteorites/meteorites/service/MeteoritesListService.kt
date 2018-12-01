package sk.mholecy.meteorites.meteorites.service

import sk.mholecy.meteorites.meteorites.api.MeteoritesApiClient
import sk.mholecy.meteorites.meteorites.api.model.ApiMeteoriteModel

class MeteoritesListService(
    private val meteoritesApiClient: MeteoritesApiClient
) {
    companion object {
        private const val WHERE_CONDITION = "year>=\"2011-01-01T00:00:00.000\""
        private const val ORDER_BY = "mass DESC"
    }

    fun getMeteoritesFromApi(): List<ApiMeteoriteModel> {
        val request = meteoritesApiClient.getMeteoritesData(
            WHERE_CONDITION,
            ORDER_BY
        )
        val response = request.execute()
        return if (response.isSuccessful) {
            response.body() ?: emptyList()
        } else {
            emptyList()
        }
    }
}
