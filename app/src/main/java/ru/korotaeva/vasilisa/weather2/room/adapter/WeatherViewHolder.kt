package ru.korotaeva.vasilisa.weather2.room.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.korotaeva.vasilisa.weather2.R
import ru.korotaeva.vasilisa.weather2.model.weatherOfCity.WeatherOfTheCity

class WeatherViewHolder(  view: View) : RecyclerView.ViewHolder(view) {
    val date=view.findViewById<TextView>(R.id.date)
    val temperature=view.findViewById<TextView>(R.id.temperature)
    val humidity=view.findViewById<TextView>(R.id.humidity)
    val pressure=view.findViewById<TextView>(R.id.pressure)

}