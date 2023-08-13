package com.abhi41.kesritourstaskone.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.abhi41.kesritourstaskone.data.local.entity.TourInfoEntity

@Dao
interface TourInfoDao {

    @Query("SELECT * FROM tourinfoentity")
    suspend fun getToursInfo(): List<TourInfoEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTourInfos(tourInfos: List<TourInfoEntity>)

    @Query("DELETE FROM tourinfoentity")
    suspend fun deleteTourInofs()

}