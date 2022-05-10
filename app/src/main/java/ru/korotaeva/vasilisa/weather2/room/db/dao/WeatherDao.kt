package ru.korotaeva.vasilisa.weather2.room.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.IGNORE
import androidx.room.Query
import ru.korotaeva.vasilisa.weather2.room.modelForDb.WeatherModel

@Dao
interface WeatherDao {
    @Insert(onConflict = IGNORE)
    suspend fun  insert(weatherModel: WeatherModel)
    @Delete
    suspend fun delete(weatherModel: WeatherModel)
    @Query("SELECT * from weather_table ORDER BY date")
    fun getAllWeather():LiveData<List<WeatherModel>>

    @Query("DELETE FROM weather_table")
    fun deleteAll()
}