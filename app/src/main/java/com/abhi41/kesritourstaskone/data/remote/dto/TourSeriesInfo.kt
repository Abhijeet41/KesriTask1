package com.abhi41.kesritourstaskone.data.remote.dto


import com.google.gson.annotations.SerializedName

data class TourSeriesInfo(
    @SerializedName("airline_route")
    val airlineRoute: String,
    @SerializedName("cities_covered")
    val citiesCovered: List<CitiesCovered> = emptyList(),
    @SerializedName("competitor_agent_used")
    val competitorAgentUsed: String,
    @SerializedName("competitor_company")
    val competitorCompany: String,
    @SerializedName("continents")
    val continents: String,
    @SerializedName("countries_covered")
    val countriesCovered: List<String>,
    @SerializedName("end_city_point")
    val endCityPoint: String,
    @SerializedName("end_country")
    val endCountry: String,
    @SerializedName("guest_potential_city")
    val guestPotentialCity: String,
    @SerializedName("guest_type")
    val guestType: String,
    @SerializedName("hotel_suggested")
    val hotelSuggested: String,
    @SerializedName("journey_by_road")
    val journeyByRoad: String,
    @SerializedName("precautions")
    val precautions: String,
    @SerializedName("start_city_point")
    val startCityPoint: String,
    @SerializedName("start_country")
    val startCountry: String,
    @SerializedName("static_map_image")
    val staticMapImage: String,
    @SerializedName("things_to_carry")
    val thingsToCarry: String,
    @SerializedName("total_city")
    val totalCity: Int,
    @SerializedName("total_country")
    val totalCountry: Int,
    @SerializedName("tour_operator")
    val tourOperator: String,
    @SerializedName("tour_route")
    val tourRoute: String,
    @SerializedName("transport_agent_suggested")
    val transportAgentSuggested: String
)