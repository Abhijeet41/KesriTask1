package com.abhi41.kesritourstaskone.data.remote.dto


import com.google.gson.annotations.SerializedName

data class AdditionalDiscount(
    @SerializedName("amount")
    val amount: String,
    @SerializedName("name")
    val name: String
)