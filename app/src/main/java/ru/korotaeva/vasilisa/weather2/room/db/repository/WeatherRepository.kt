package ru.korotaeva.vasilisa.weather2.room.db.repository

import androidx.lifecycle.LiveData
import ru.korotaeva.vasilisa.weather2.room.modelForDb.WeatherModel

interface WeatherRepository {
    val allWeather: LiveData<List<WeatherModel>>

    suspend fun insertWeather(weatherModel: WeatherModel,onSuccess:()->Unit)
    suspend fun deleteWeather(weatherModel: WeatherModel,onSuccess:()->Unit)
}