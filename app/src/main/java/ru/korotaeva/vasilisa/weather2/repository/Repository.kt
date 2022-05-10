package ru.korotaeva.vasilisa.weather2.repository

import ru.korotaeva.vasilisa.weather2.api.RetrofitInstance
import ru.korotaeva.vasilisa.weather2.model.geo.GeocodingItem
import ru.korotaeva.vasilisa.weather2.model.weatherOfCity.WeatherOfTheCity

class Repository {
    suspend fun getLocationOfCity(city:String): ArrayList<GeocodingItem> {
        return RetrofitInstance.api.getLocation(city)
    }

    suspend fun getWeatherOfTheCity(lat:String,lon:String): WeatherOfTheCity {
        return  RetrofitInstance.api.getWeather(lat,lon)
    }
}