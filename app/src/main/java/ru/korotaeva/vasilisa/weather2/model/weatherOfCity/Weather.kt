package ru.korotaeva.vasilisa.weather2.model.weatherOfCity

data class Weather(
    val description: String,
    val icon: String,
    val id: Int,
    val main: String
)