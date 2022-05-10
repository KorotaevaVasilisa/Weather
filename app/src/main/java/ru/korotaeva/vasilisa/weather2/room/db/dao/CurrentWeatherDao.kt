package ru.korotaeva.vasilisa.weather2.room.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import ru.korotaeva.vasilisa.weather2.room.modelForDb.CurrentWeatherModel

@Dao
interface CurrentWeatherDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun  insert(currentWeatherModel: CurrentWeatherModel)
    @Delete
    suspend fun delete(currentWeatherModel: CurrentWeatherModel)
    @Query("SELECT * from current_table ")
    fun getCurrentWeather(): LiveData<CurrentWeatherModel>

    @Query("DELETE FROM current_table")
    fun deleteAll()
}