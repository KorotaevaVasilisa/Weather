package ru.korotaeva.vasilisa.weather2.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Response
import ru.korotaeva.vasilisa.weather2.model.weatherOfCity.WeatherOfTheCity
import ru.korotaeva.vasilisa.weather2.repository.Repository
import kotlin.time.Duration.Companion.days

class MainViewModel : ViewModel() {
    // TODO: Implement the ViewModel
    private lateinit var lat:String
    private lateinit var lon:String
    var repository = Repository()
        //  val infoList: MutableLiveData<Response<WeatherOfTheCity>> = MutableLiveData()
    fun search(city: String) {
        viewModelScope.launch {
            val response = repository.getLocationOfCity(city)
           lat= response[0].lat.toString()
            lon= response[0].lon.toString()
            getAllInfo()
        }


    }

    fun getAllInfo() {
        viewModelScope.launch {
           println( repository.getWeatherOfTheCity(lat, lon))
            println(repository.getWeatherOfTheCity(lat, lon).daily[0].dt)
        }
    }
}