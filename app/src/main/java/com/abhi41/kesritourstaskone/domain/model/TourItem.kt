package com.abhi41.kesritourstaskone.domain.model

data class TourItem(
    val tourCode: String,
    val tourName: String,
    val tm_Zone: String,
    val images: List<String>,
    val bestSeller: String,
    val start_country: String,
    val generated_DISC_2DAY: Int,
    val generated_NETCOST: Int,
    val start_city: String,
    val end_city: String,
    val total_city: Int,
    val journeyCategory: String,
    val tourmas0Item: TOURMAS0,
    val total_country: Int,
    val numberOfNights: Int,
)
