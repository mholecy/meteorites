package sk.mholecy.meteorites.meteorites.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "meteorites")
data class DbMeteoriteModel(
    @PrimaryKey
    val id: Long,

    @ColumnInfo(name = "fall")
    val fall: String,

    @ColumnInfo(name = "type")
    val type: String?,

    @ColumnInfo(name = "mass")
    val mass: Double,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "name_type")
    val nameType: String,

    @ColumnInfo(name = "rec_class")
    val recClass: String,

    @ColumnInfo(name = "latitude")
    val latitude: Double,

    @ColumnInfo(name = "longitude")
    val longitude: Double,

    @ColumnInfo(name = "year")
    val year: Int
) {
    val hasLocation: Boolean
        get() = latitude != 0.0 || this.longitude != 0.0


}
