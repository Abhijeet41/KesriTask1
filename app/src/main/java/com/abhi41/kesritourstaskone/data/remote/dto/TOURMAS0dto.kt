package com.abhi41.kesritourstaskone.data.remote.dto


import com.abhi41.kesritourstaskone.domain.model.TOURMAS0
import com.google.gson.annotations.SerializedName

data class TOURMAS0dto(
    @SerializedName("TM_DAYS")
    val tMDAYS: Int,
){
    fun toTourmas0(): TOURMAS0 {
        return TOURMAS0(
            tm_days = tMDAYS
        )
    }
}