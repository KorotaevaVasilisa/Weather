package ru.korotaeva.vasilisa.weather2.room.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_layout.view.*
import ru.korotaeva.vasilisa.weather2.R
import ru.korotaeva.vasilisa.weather2.databinding.ItemLayoutBinding
import ru.korotaeva.vasilisa.weather2.room.modelForDb.WeatherModel

class WeatherAdapter : RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder>() {
    var listWeather = emptyList<WeatherModel>()
    lateinit var binding: ItemLayoutBinding


    class WeatherViewHolder(view: View) : RecyclerView.ViewHolder(view) {


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        // binding= ItemLayoutBinding.inflate()
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return WeatherViewHolder(view)

    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        holder.itemView.pressure.text = listWeather[position].pressure.toString()
//        binding.humidity.text = listWeather[position].humidity.toString()
//        binding.temperature.text = listWeather[position].temperature.toString()
//        binding.data.text = listWeather[position].data
        holder.itemView.humidity.text = listWeather[position].humidity.toString()
        holder.itemView.temperature.text = listWeather[position].temperature.toString()
        holder.itemView.date.text = listWeather[position].date.toString()
    }

    override fun getItemCount(): Int {
        return listWeather.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<WeatherModel>) {
        listWeather = list
        notifyDataSetChanged()
    }
}