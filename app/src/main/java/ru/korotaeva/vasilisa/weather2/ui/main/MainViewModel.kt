package ru.korotaeva.vasilisa.weather2.ui.main

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    // TODO: Implement the ViewModel
private val key="f70de23578e62f51050edc52c3345f6c"

    fun search(city: String){
        var url="https://api.openweathermap.org/geo/1.0/direct?q="+city+"&limit=5&appid="+key+"&units=metric&lang=ru"

    new
    }
}