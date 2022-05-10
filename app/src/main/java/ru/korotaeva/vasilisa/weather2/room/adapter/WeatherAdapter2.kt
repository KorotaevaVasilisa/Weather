package ru.korotaeva.vasilisa.weather2.room.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import ru.korotaeva.vasilisa.weather2.R
import ru.korotaeva.vasilisa.weather2.model.weatherOfCity.WeatherOfTheCity
import ru.korotaeva.vasilisa.weather2.room.modelForDb.WeatherModel
import java.text.SimpleDateFormat
import java.util.*

class WeatherAdapter2(diffCallback: DiffUtil.ItemCallback<WeatherModel>) :
    ListAdapter<WeatherModel, WeatherViewHolder>(diffCallback) {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): WeatherViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return WeatherViewHolder(view)
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        val item = getItem(position)


        val date = Date(item.date *1000L)
        val sdf = SimpleDateFormat("dd.MM")
        sdf.timeZone = TimeZone.getTimeZone("GMT+6")
        val formattedDate = sdf.format(date)


        holder.date.text = formattedDate
        holder.temperature.text = item.temperature.toString()
        holder.humidity.text = item.humidity.toString()
        holder.pressure.text = item.pressure.toString()
    }
}