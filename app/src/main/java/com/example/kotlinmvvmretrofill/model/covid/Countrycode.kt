package com.example.kotlinmvvmretrofill.model.covid


import com.google.gson.annotations.SerializedName

data class Countrycode(
    @SerializedName("iso2")
    val iso2: String,
    @SerializedName("iso3")
    val iso3: String
)