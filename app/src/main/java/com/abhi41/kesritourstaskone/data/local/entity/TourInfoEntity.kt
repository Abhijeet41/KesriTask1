package com.abhi41.kesritourstaskone.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.abhi41.kesritourstaskone.domain.model.TOURMAS0
import com.abhi41.kesritourstaskone.domain.model.TourItem

@Entity
data class TourInfoEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
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
    val total_country: Int,
    val numberOfNights: Int,
    val tm_days: Int
) {
    fun toToursModel(): TourItem {
        return TourItem(
            tourCode,
            tourName,
            tm_Zone,
            images,
            bestSeller,
            start_country,
            generated_DISC_2DAY,
            generated_NETCOST,
            start_city,
            end_city,
            total_city,
            journeyCategory,
            TOURMAS0(tm_days),
            total_country,
            numberOfNights
        )
    }
}
