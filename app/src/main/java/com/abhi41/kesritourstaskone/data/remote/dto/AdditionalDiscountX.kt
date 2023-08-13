package com.abhi41.kesritourstaskone.data.remote.dto


import com.google.gson.annotations.SerializedName

data class AdditionalDiscountX(
    @SerializedName("amount")
    val amount: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("OFR_AD")
    val oFRAD: Int,
    @SerializedName("OFR_CH12")
    val oFRCH12: Int,
    @SerializedName("OFR_CH1318")
    val oFRCH1318: Int,
    @SerializedName("OFR_CH25")
    val oFRCH25: Int,
    @SerializedName("OFR_CH512")
    val oFRCH512: Int,
    @SerializedName("TC_TCD")
    val tCTCD: String,
    @SerializedName("validFrom")
    val validFrom: String,
    @SerializedName("validTill")
    val validTill: String
)