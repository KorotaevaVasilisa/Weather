package ru.korotaeva.vasilisa.weather2.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ru.korotaeva.vasilisa.weather2.room.db.dao.CurrentWeatherDao
import ru.korotaeva.vasilisa.weather2.room.db.dao.WeatherDao
import ru.korotaeva.vasilisa.weather2.room.modelForDb.CurrentWeatherModel
import ru.korotaeva.vasilisa.weather2.room.modelForDb.WeatherModel

@Database(
    entities = [
        WeatherModel::class,
        CurrentWeatherModel::class
    ], version = 1
)
abstract class WeatherDatabase : RoomDatabase() {

    abstract fun getWeatherDao(): WeatherDao

    companion object {
        private var database: WeatherDatabase? = null

        @Synchronized
        fun getInstance(context: Context): WeatherDatabase {
            return if (database == null) {
                database = Room.databaseBuilder(context, WeatherDatabase::class.java, "db").build()
                database as WeatherDatabase
            } else {
                database as WeatherDatabase
            }
        }

    }

    abstract fun getCurrentWeatherDao(): CurrentWeatherDao


}