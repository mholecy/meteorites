package sk.mholecy.meteorites.meteorites.api.model

class ApiMeteoriteModel(
    val fall: String,
    val type: String?,
    val id: Long,
    val mass: Double,
    val name: String,
    val nametype: String,
    val recclass: String,
    val reclat: Double,
    val reclong: Double,
    val year: String
)
