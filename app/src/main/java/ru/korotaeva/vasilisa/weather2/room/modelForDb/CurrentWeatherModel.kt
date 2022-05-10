package ru.korotaeva.vasilisa.weather2.room.modelForDb

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "current_table")
class CurrentWeatherModel (
    @PrimaryKey(autoGenerate = true)
    var id:Int=0,
    @ColumnInfo
    var date:Long=0,
    @ColumnInfo
    var feels_like:Double=0.0,
    @ColumnInfo
    var temperature: Double=0.0,
    @ColumnInfo
    var humidity:Int=0,
    @ColumnInfo
    var pressure:Int=0
        )