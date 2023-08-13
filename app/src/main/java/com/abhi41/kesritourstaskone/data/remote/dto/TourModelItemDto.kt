package com.abhi41.kesritourstaskone.data.remote.dto


import com.abhi41.kesritourstaskone.data.local.entity.TourInfoEntity
import com.abhi41.kesritourstaskone.domain.model.TourItem
import com.google.gson.annotations.SerializedName

data class TourModelItemDto(
   /* @SerializedName("additionalDiscount")
    val additionalDiscount: AdditionalDiscount,*/
/*    @SerializedName("app_tourzoneimages")
    val appTourzoneimages: String,*/
    @SerializedName("bestSeller")
    val bestSeller: String? = null,
   /* @SerializedName("currency")
    val currency: String,*/
/*    @SerializedName("Departures")
    val departures: List<String>,*/
    @SerializedName("end_city")
    val endCity: String?,
    @SerializedName("end_country")
    val endCountry: String?,
/*    @SerializedName("F_BUSTYPE")
    val fBUSTYPE: String,
    @SerializedName("F_HTLCATG")
    val fHTLCATG: String,
    @SerializedName("F_MEALTYPE")
    val fMEALTYPE: String,
    @SerializedName("F_SPLMEAL1")
    val fSPLMEAL1: String,
    @SerializedName("F_TOPPING1")
    val fTOPPING1: String,
    @SerializedName("F_TYPE")
    val fTYPE: String,
    @SerializedName("F_VALERT1")
    val fVALERT1: String,
    @SerializedName("F_VALERT2")
    val fVALERT2: String,
    @SerializedName("F_VALERT3")
    val fVALERT3: String,*/
 /*   @SerializedName("generated_COST_2DAY")
    val generatedCOST2DAY: Int,*/
/*    @SerializedName("generated_COST_CUR")
    val generatedCOSTCUR: String,*/
/*    @SerializedName("generated_COST_FRX")
    val generatedCOSTFRX: String,
    @SerializedName("generated_COST_INR")
    val generatedCOSTINR: String,*/
    @SerializedName("generated_DISC_2DAY")
    val generatedDISC2DAY: String,
    @SerializedName("generated_NETCOST")
    val generatedNETCOST: String,
   /* @SerializedName("generated_TM_DT1")
    val generatedTMDT1: String,*/
/*    @SerializedName("ITINERARY_COUNT")
    val iTINERARYCOUNT: Int,*/
/*    @SerializedName("_id")
    val id: String,*/
    @SerializedName("images")
    val images: List<String>?,
   /* @SerializedName("JL_COST")
    val jLCOST: String,*/
    @SerializedName("journeyCategory")
    val journeyCategory: String?,
/*    @SerializedName("SUGG_AIRLN")
    val sUGGAIRLN: String,*/
    @SerializedName("start_city")
    val startCity: String?,
    @SerializedName("start_country")
    val startCountry: String?,
  /*  @SerializedName("TM_ID")
    val tMID: String,*/
    @SerializedName("TM_ZONE")
    val tMZONE: String?,
    @SerializedName("TOURCODE")
    val tOURCODE: String?,
  /*  @SerializedName("TOUR_ID")
    val tOURID: String,*/
    @SerializedName("TOURMAS0")
    val tOURMAS0: List<TOURMAS0dto?>,
    @SerializedName("TOURNAME")
    val tOURNAME: String?,
    @SerializedName("total_city")
    val totalCity: Int? = null,
    @SerializedName("total_country")
    val totalCountry: Int? = null,
    @SerializedName("tour_series_info")
    val tourSeriesInfo: TourSeriesInfo,
/*    @SerializedName("tour_usp")
    val tourUsp: TourUsp,*/
    @SerializedName("tourcode_allimages")
    val tourcodeAllimages: List<TourcodeAllimage?>,
 /*   @SerializedName("tourzoneimages")
    val tourzoneimages: String,*/
  /*  @SerializedName("visit")
    val visit: String*/
){
    fun toTourModelItem(): TourInfoEntity {
        return TourInfoEntity(
            tourCode = tOURCODE ?:"",
            tourName = tOURNAME ?:"",
            tm_Zone = tMZONE ?:"",
            images = images ?: emptyList(),
            bestSeller = bestSeller ?:"",
            start_country = startCountry ?:"",
            generated_DISC_2DAY = if (generatedDISC2DAY.isNotEmpty()) generatedDISC2DAY.toInt() else 0,
            generated_NETCOST = if (generatedNETCOST.isNotEmpty()) generatedNETCOST.toInt() else 0,
            start_city = startCity ?: "",
            end_city = endCity ?: "",
            total_city = totalCity ?: 0,
            journeyCategory = journeyCategory ?: "",
            total_country = totalCountry ?: 0,
            numberOfNights = if (tourSeriesInfo.citiesCovered.isNotEmpty()) tourSeriesInfo.citiesCovered.get(0).numberOfNights else 0 ,
           // numberOfNights = 10,
            tm_days = if (tOURMAS0 == null) 0 else tOURMAS0[0]?.tMDAYS ?: 0,
        )
    }

}