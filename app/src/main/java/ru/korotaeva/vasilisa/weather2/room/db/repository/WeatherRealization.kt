package ru.korotaeva.vasilisa.weather2.room.db.repository

import androidx.lifecycle.LiveData
import ru.korotaeva.vasilisa.weather2.room.db.dao.WeatherDao
import ru.korotaeva.vasilisa.weather2.room.modelForDb.WeatherModel

class WeatherRealization(private val weatherDao: WeatherDao)  {
    val allWeather: LiveData<List<WeatherModel>>
        get() = weatherDao.getAllWeather()

    suspend fun insertWeather(weatherModel: WeatherModel) {
        weatherDao.insert(weatherModel)
    }

    suspend fun deleteWeather(weatherModel: WeatherModel) {
        weatherDao.delete(weatherModel)

    }

    fun deleteAllWeather() {
        weatherDao.deleteAll()

    }
}