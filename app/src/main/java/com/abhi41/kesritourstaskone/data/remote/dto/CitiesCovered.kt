package com.abhi41.kesritourstaskone.data.remote.dto


import com.google.gson.annotations.SerializedName

data class CitiesCovered(
    @SerializedName("city_name")
    val cityName: String,
    @SerializedName("country_name")
    val countryName: String,
    @SerializedName("_id")
    val id: String,
    @SerializedName("iso_code_2")
    val isoCode2: String,
    @SerializedName("number_of_nights")
    val numberOfNights: Int
)