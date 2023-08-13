package com.abhi41.kesritourstaskone.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.abhi41.kesritourstaskone.data.local.converter.Converters
import com.abhi41.kesritourstaskone.data.local.dao.TourInfoDao
import com.abhi41.kesritourstaskone.data.local.entity.TourInfoEntity

@Database(
    entities = [TourInfoEntity::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class TourInfoDatabase: RoomDatabase() {
    abstract val dao: TourInfoDao
}