package com.abhi41.kesritourstaskone.domain.use_case

import com.abhi41.kesritourstaskone.domain.model.TourItem
import com.abhi41.kesritourstaskone.domain.repository.TourInfoRepository
import com.abhi41.kesritourstaskone.util.Resource
import kotlinx.coroutines.flow.Flow

class GetTourInfo(
    private val repository: TourInfoRepository
) {
    operator fun invoke(): Flow<Resource<List<TourItem>>> {
        return repository.getTourInfo()
    }
}