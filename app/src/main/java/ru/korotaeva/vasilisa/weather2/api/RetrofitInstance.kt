package ru.korotaeva.vasilisa.weather2.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitInstance {
//    val interceptor = HttpLoggingInterceptor()
//    interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
//
//    val client = OkHttpClient.Builder()
//        .addInterceptor(interceptor)
//        .build()
    private val retrofit by lazy{
        Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val api:ApiService by lazy{
      retrofit.create(ApiService::class.java)
    }

}