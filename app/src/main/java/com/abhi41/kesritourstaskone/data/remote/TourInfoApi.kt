package com.abhi41.kesritourstaskone.data.remote

import com.abhi41.kesritourstaskone.data.remote.dto.TourModelItemDto
import retrofit2.http.GET

interface TourInfoApi {

    @GET("route/inventory/getTourPackageDataApp/0/Andaman/0")
    suspend fun getTourList(): List<TourModelItemDto>
}