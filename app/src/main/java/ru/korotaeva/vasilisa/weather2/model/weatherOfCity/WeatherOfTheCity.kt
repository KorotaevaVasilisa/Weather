package ru.korotaeva.vasilisa.weather2.model.weatherOfCity

data class WeatherOfTheCity(
    val current: Current,
    val daily: List<Daily>,
    val lat: Double,
    val lon: Double,
    val timezone: String,
    val timezone_offset: Int
)