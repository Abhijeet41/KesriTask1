package com.abhi41.kesritourstaskone.presentation

import com.abhi41.kesritourstaskone.domain.model.TourItem

data class TourInfoState(
    val tourInfoItem: List<TourItem> = emptyList(),
    val isLoading: Boolean = false
)
