package sk.mholecy.meteorites.meteorites.api.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class ApiMeteoriteModel(
    val fall: String,
    val type: String?,
    val id: String,
    val mass: Double,
    val name: String,
    val nametype: String,
    val recclass: String,
    val reclat: Double,
    val reclong: Double,
    val year: String
)
