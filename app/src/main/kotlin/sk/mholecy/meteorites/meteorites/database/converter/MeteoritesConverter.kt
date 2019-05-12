package sk.mholecy.meteorites.meteorites.database.converter

import sk.mholecy.meteorites.meteorites.api.model.ApiMeteoriteModel
import sk.mholecy.meteorites.meteorites.database.model.DbMeteoriteModel
import javax.inject.Inject

class MeteoritesConverter @Inject constructor() {

    fun convertToDbObject(apiMeteoriteModel: ApiMeteoriteModel): DbMeteoriteModel {
        return DbMeteoriteModel(
            id = apiMeteoriteModel.id,
            fall = apiMeteoriteModel.fall,
            type = apiMeteoriteModel.type,
            mass = apiMeteoriteModel.mass,
            name = apiMeteoriteModel.name,
            nameType = apiMeteoriteModel.nametype,
            recClass = apiMeteoriteModel.recclass,
            latitude = apiMeteoriteModel.reclat,
            longitude = apiMeteoriteModel.reclong,
            year = apiMeteoriteModel.year.substring(0, 4).toInt()
        )
    }
}
