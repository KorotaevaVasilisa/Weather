package ru.korotaeva.vasilisa.weather2.room.db.repository

import androidx.lifecycle.LiveData
import ru.korotaeva.vasilisa.weather2.room.db.dao.CurrentWeatherDao
import ru.korotaeva.vasilisa.weather2.room.modelForDb.CurrentWeatherModel


class CurrentRealization(private val currentWeatherDAO: CurrentWeatherDao) {
    val currentWeather: LiveData<CurrentWeatherModel>
        get() = currentWeatherDAO.getCurrentWeather()


    suspend fun insertCurrentWeather(currentWeatherModel: CurrentWeatherModel) {
        currentWeatherDAO.insert(currentWeatherModel)
    }


    fun deleteCurrentWeather() {
        currentWeatherDAO.deleteAll()

    }
}