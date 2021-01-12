package sk.mholecy.meteorites.meteorites.api

import retrofit2.http.GET
import retrofit2.http.Query
import sk.mholecy.meteorites.meteorites.api.model.ApiMeteoriteModel

interface MeteoritesApiClient {

    @GET("resource/y77d-th95.json")
    suspend fun getMeteoritesData(
        @Query("\$where") whereCondition: String
    ): List<ApiMeteoriteModel>
}
