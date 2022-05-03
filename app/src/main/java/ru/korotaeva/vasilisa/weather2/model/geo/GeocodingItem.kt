package ru.korotaeva.vasilisa.weather2.model.geo

data class GeocodingItem(
    val country: String,
    val lat: Double,
    val local_names: LocalNames,
    val lon: Double,
    val name: String,
    val state: String
)