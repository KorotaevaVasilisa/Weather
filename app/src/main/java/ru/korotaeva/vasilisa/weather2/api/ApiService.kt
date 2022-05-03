package ru.korotaeva.vasilisa.weather2.api

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import ru.korotaeva.vasilisa.weather2.model.geo.Geocoding
import ru.korotaeva.vasilisa.weather2.model.geo.GeocodingItem
import ru.korotaeva.vasilisa.weather2.model.weatherOfCity.WeatherOfTheCity

interface ApiService {
    @GET("geo/1.0/direct?limit=5&appid=f70de23578e62f51050edc52c3345f6c")
    suspend fun getLocation(@Query("q")  city:String ):ArrayList<GeocodingItem>

    @GET("data/2.5/onecall?&units=metric&lang=ru&exclude=minutely,hourly,alerts&appid=f70de23578e62f51050edc52c3345f6c")
    suspend fun getWeather(@Query("lat")  lat:String ,
                           @Query("lon") lon:String
                           ):WeatherOfTheCity


    }
