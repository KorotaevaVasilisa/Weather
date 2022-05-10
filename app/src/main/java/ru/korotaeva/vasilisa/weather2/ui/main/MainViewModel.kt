package ru.korotaeva.vasilisa.weather2.ui.main

import android.app.Application
import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Response
import ru.korotaeva.vasilisa.weather2.model.weatherOfCity.WeatherOfTheCity
import ru.korotaeva.vasilisa.weather2.repository.Repository
import ru.korotaeva.vasilisa.weather2.room.WeatherDatabase
import ru.korotaeva.vasilisa.weather2.room.db.repository.WeatherRealization
import ru.korotaeva.vasilisa.weather2.room.db.repository.WeatherRepository
import ru.korotaeva.vasilisa.weather2.room.modelForDb.WeatherModel
import kotlin.time.Duration.Companion.days

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private lateinit var lat: String
    private lateinit var lon: String
    private val context = application
    private var repository = Repository()

    // var repositoryDb= WeatherRealization(WeatherDatabase.getInstance(context).getWeatherDao())
    private lateinit var repositoryDb: WeatherRealization

    // var infoList: MutableLiveData<WeatherOfTheCity> = MutableLiveData()

    fun search(city: String) {
        viewModelScope.launch {
            val response = repository.getLocationOfCity(city)
            lat = response[0].lat.toString()
            lon = response[0].lon.toString()

            delete()
            val info = repository.getWeatherOfTheCity(lat, lon)
            for (i in 0..5) {
                val humidity = info.daily[i].humidity
                val data = info.daily[i].dt
                val pressure = info.daily[i].pressure
                val temp = info.daily[i].temp
                insert(
                    WeatherModel(
                        temperature = temp.day,
                        date = data,
                        humidity = humidity,
                        pressure = pressure
                    )
                )
            }
        }


    }


    fun initDatabase() {
        val daoWeather = WeatherDatabase.getInstance(context).getWeatherDao()
        repositoryDb = WeatherRealization(daoWeather)
    }

    fun getAllWeather(): LiveData<List<WeatherModel>> {
        return repositoryDb.allWeather
    }

    fun insert(weatherModel: WeatherModel) =
        viewModelScope.launch(Dispatchers.IO) {
            repositoryDb!!.insertWeather(weatherModel)


        }

    fun delete() =
        viewModelScope.launch(Dispatchers.IO) {
            repositoryDb!!.deleteAllWeather()
        }
}
