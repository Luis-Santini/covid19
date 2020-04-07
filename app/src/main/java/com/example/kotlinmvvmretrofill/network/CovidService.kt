package com.example.kotlinmvvmretrofill.network


import com.example.kotlinmvvmretrofill.model.covid.CovidCountries
import retrofit2.http.GET

interface CovidService {

@GET("jhu-edu/latest")
suspend fun getLatest():List<CovidCountries>


}