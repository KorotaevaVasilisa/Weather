package ru.korotaeva.vasilisa.weather2.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.korotaeva.vasilisa.weather2.databinding.MainFragmentBinding
import ru.korotaeva.vasilisa.weather2.room.adapter.WeatherAdapter2
import ru.korotaeva.vasilisa.weather2.room.modelForDb.WeatherModel

class MainFragment : Fragment() {
    private lateinit var binding: MainFragmentBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: WeatherAdapter2

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MainFragmentBinding.inflate(layoutInflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()

    }


    private fun init() {
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.initDatabase()
        recyclerView = binding.rvWeather
        adapter = WeatherAdapter2(object : DiffUtil.ItemCallback<WeatherModel>() {
            override fun areItemsTheSame(oldItem: WeatherModel, newItem: WeatherModel): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: WeatherModel, newItem: WeatherModel): Boolean {
                return oldItem.equals(newItem)
            }

        })

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)
        viewModel.getAllWeather().observe(viewLifecycleOwner) { listWeather ->
            adapter.submitList(listWeather)
        }
        viewModel.getCurrent().observe(viewLifecycleOwner) { item ->
            if (item != null) {
                binding.textHumidity.text = item.humidity.toString()+"%"
                binding.textPressure.text = item.pressure.toString()
                binding.textWeather.text = item.temperature.toString()+"°"
                binding.textFeels.text = item.feels_like.toString()
            }
        }
        binding.button.setOnClickListener {

            if (binding.editTextTextPersonName.text.toString().trim() == "") {
                Toast.makeText(activity, "Введите город", Toast.LENGTH_LONG).show()
            } else {
                viewModel.search(binding.editTextTextPersonName.text.toString())

            }

        }

    }
}