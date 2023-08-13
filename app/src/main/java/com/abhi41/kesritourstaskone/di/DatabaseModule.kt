package com.abhi41.kesritourstaskone.di

import android.app.Application
import androidx.room.Room
import com.abhi41.kesritourstaskone.data.local.converter.Converters
import com.abhi41.kesritourstaskone.data.local.database.TourInfoDatabase
import com.abhi41.kesritourstaskone.util.Constants.TOUR_INFO_DATABASE
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideTourInfoDatabase(
        app: Application
    ): TourInfoDatabase {
        return Room.databaseBuilder(
            app,
            TourInfoDatabase::class.java,
            TOUR_INFO_DATABASE
        ).addTypeConverter(Converters()).build()
    }

}