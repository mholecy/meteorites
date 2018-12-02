package sk.mholecy.meteorites.common.database

import androidx.room.Database
import androidx.room.RoomDatabase
import sk.mholecy.meteorites.meteorites.database.dao.MeteoritesDao
import sk.mholecy.meteorites.meteorites.database.model.DbMeteoriteModel

@Database(
    entities = [DbMeteoriteModel::class],
    version = 1,
    exportSchema = false
)

abstract class Database : RoomDatabase() {
    abstract fun meteoritesDao(): MeteoritesDao
}
