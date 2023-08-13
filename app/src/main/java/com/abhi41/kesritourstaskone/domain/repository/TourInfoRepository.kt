package com.abhi41.kesritourstaskone.domain.repository

import com.abhi41.kesritourstaskone.data.remote.dto.TourModelItemDto
import com.abhi41.kesritourstaskone.domain.model.TourItem
import com.abhi41.kesritourstaskone.util.Resource
import kotlinx.coroutines.flow.Flow

interface TourInfoRepository {

    fun getTourInfo(): Flow<Resource<List<TourItem>>>

}