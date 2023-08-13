package com.abhi41.kesritourstaskone.di

import com.abhi41.kesritourstaskone.data.local.dao.TourInfoDao
import com.abhi41.kesritourstaskone.data.local.database.TourInfoDatabase
import com.abhi41.kesritourstaskone.data.remote.TourInfoApi
import com.abhi41.kesritourstaskone.data.repository_impl.TourInfoRepositoryImpl
import com.abhi41.kesritourstaskone.domain.repository.TourInfoRepository
import com.abhi41.kesritourstaskone.domain.use_case.GetTourInfo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object TourInfoModule {


    @Provides
    @Singleton
    fun provideTourInfoRepository(
        db: TourInfoDatabase,
        api: TourInfoApi
    ): TourInfoRepository{
        return TourInfoRepositoryImpl(api, db.dao)
    }

    @Provides
    @Singleton
    fun provideGetTourInfoUseCase(
        repository: TourInfoRepository
    ): GetTourInfo{
        return GetTourInfo(repository)
    }

}