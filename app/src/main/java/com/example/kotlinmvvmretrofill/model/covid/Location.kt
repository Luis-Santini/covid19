package com.example.kotlinmvvmretrofill.model.covid


import com.google.gson.annotations.SerializedName

data class Location(
    @SerializedName("lat")
    val lat: Float,
    @SerializedName("lng")
    val lng: Float
)