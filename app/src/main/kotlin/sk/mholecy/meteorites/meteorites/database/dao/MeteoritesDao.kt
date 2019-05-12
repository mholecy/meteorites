package sk.mholecy.meteorites.meteorites.database.dao

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import sk.mholecy.meteorites.meteorites.database.model.DbMeteoriteModel

@Dao
interface MeteoritesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(meteoriteModel: DbMeteoriteModel)

    @Query("DELETE FROM meteorites")
    fun deleteAll()

    @Query("SELECT * from meteorites ORDER BY mass DESC")
    fun getMeteorites(): LiveData<List<DbMeteoriteModel>>

    @Query("SELECT * from meteorites ORDER BY mass DESC")
    fun getMeteoritesPaged(): DataSource.Factory<Int, DbMeteoriteModel>

    @Query("SELECT * from meteorites ORDER BY id DESC LIMIT 1")
    fun getMaxId(): DbMeteoriteModel?

    @Query("SELECT * from meteorites WHERE id = :meteoriteId")
    fun getMeteorite(meteoriteId: Long): LiveData<DbMeteoriteModel>

    @Query("SELECT count(*) from meteorites")
    fun getMeteoritesCount(): LiveData<Long>
}
