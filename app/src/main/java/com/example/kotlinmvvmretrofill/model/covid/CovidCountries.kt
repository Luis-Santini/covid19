package com.example.kotlinmvvmretrofill.model.covid


import com.google.gson.annotations.SerializedName

data class CovidCountries(
    @SerializedName("confirmed")
    val confirmed: Int,
    @SerializedName("countrycode")
    val countrycode: Countrycode,
    @SerializedName("countryregion")
    val countryregion: String,
    @SerializedName("deaths")
    val deaths: Int,
    @SerializedName("lastupdate")
    val lastupdate: String,
    @SerializedName("location")
    val location: Location,
    @SerializedName("provincestate")
    val provincestate: String,
    @SerializedName("recovered")
    val recovered: Int
)