package ru.korotaeva.vasilisa.weather2.ui.main

import android.app.Application
import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.korotaeva.vasilisa.weather2.repository.Repository
import ru.korotaeva.vasilisa.weather2.room.WeatherDatabase
import ru.korotaeva.vasilisa.weather2.room.db.repository.CurrentRealization
import ru.korotaeva.vasilisa.weather2.room.db.repository.WeatherRealization
import ru.korotaeva.vasilisa.weather2.room.modelForDb.CurrentWeatherModel
import ru.korotaeva.vasilisa.weather2.room.modelForDb.WeatherModel

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private lateinit var lat: String
    private lateinit var lon: String
    private val context = application
    private var repository = Repository()

    private lateinit var repositoryDb: WeatherRealization
    private lateinit var repositoryCurrentDb: CurrentRealization


    fun search(city: String) {
        viewModelScope.launch {
            val response = repository.getLocationOfCity(city)
            lat = response[0].lat.toString()
            lon = response[0].lon.toString()

            delete()
            val info = repository.getWeatherOfTheCity(lat, lon)

            val date = info.current.dt
            val humidity = info.current.humidity
            val pressure = info.current.pressure
            val temp = info.current.temp
            val feels_like = info.current.feels_like
            insertCurrent(
                CurrentWeatherModel(
                    temperature = temp,
                    date = date,
                    humidity = humidity,
                    pressure = pressure,
                    feels_like = feels_like
                )
            )
            for (i in 1..5) {
                val humidityDaily = info.daily[i].humidity
                val dataDaily = info.daily[i].dt
                val pressureDaily = info.daily[i].pressure
                val tempDaily = info.daily[i].temp
                insert(
                    WeatherModel(
                        temperature = tempDaily.day,
                        date = dataDaily,
                        humidity = humidityDaily,
                        pressure = pressureDaily
                    )
                )
            }
        }


    }


    fun initDatabase() {
        val daoWeather = WeatherDatabase.getInstance(context).getWeatherDao()
        repositoryDb = WeatherRealization(daoWeather)
        repositoryCurrentDb =
            CurrentRealization(WeatherDatabase.getInstance(context).getCurrentWeatherDao())
    }

    fun getAllWeather(): LiveData<List<WeatherModel>> {
        return repositoryDb.allWeather
    }

    fun insert(weatherModel: WeatherModel) =
        viewModelScope.launch(Dispatchers.IO) {
            repositoryDb.insertWeather(weatherModel)
        }

    fun insertCurrent(currentWeatherModel: CurrentWeatherModel) {
        viewModelScope.launch(Dispatchers.IO) {
            repositoryCurrentDb.insertCurrentWeather(currentWeatherModel)
        }
    }

    fun getCurrent(): LiveData<CurrentWeatherModel> {
        return repositoryCurrentDb.currentWeather
    }

    fun delete() =
        viewModelScope.launch(Dispatchers.IO) {
            repositoryDb.deleteAllWeather()
            repositoryCurrentDb.deleteCurrentWeather()
        }
}
