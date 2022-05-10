package ru.korotaeva.vasilisa.weather2.room.modelForDb

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "weather_table")
class WeatherModel(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    @ColumnInfo
    var date: Long = 0,
    @ColumnInfo
    var temperature: Double = 0.0,
    @ColumnInfo
    var humidity: Int = 0,
    @ColumnInfo
    var pressure: Int = 0
)