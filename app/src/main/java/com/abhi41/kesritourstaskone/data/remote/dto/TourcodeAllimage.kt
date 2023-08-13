package com.abhi41.kesritourstaskone.data.remote.dto


import com.google.gson.annotations.SerializedName

data class TourcodeAllimage(
    @SerializedName("path")
    val path: String,
    @SerializedName("title")
    val title: String
)