package sk.mholecy.meteorites.meteorites.database.dao

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import sk.mholecy.meteorites.meteorites.database.model.DbMeteoriteModel

@Dao
interface MeteoritesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(meteorites: List<DbMeteoriteModel>)

    @Query("SELECT * from meteorites ORDER BY mass DESC")
    fun getMeteoritesPaged(): DataSource.Factory<Int, DbMeteoriteModel>

    @Query("SELECT * from meteorites ORDER BY id DESC LIMIT 1")
    fun getMaxId(): Flow<DbMeteoriteModel?>

    @Query("SELECT * from meteorites WHERE id = :meteoriteId")
    fun getMeteorite(meteoriteId: Long): Flow<DbMeteoriteModel>

    @Query("SELECT count(*) from meteorites")
    fun getMeteoritesCount(): Flow<Long>
}
