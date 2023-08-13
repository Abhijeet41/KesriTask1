package com.abhi41.kesritourstaskone.data.repository_impl

import com.abhi41.kesritourstaskone.data.local.dao.TourInfoDao
import com.abhi41.kesritourstaskone.data.remote.TourInfoApi
import com.abhi41.kesritourstaskone.domain.model.TourItem
import com.abhi41.kesritourstaskone.domain.repository.TourInfoRepository
import com.abhi41.kesritourstaskone.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class TourInfoRepositoryImpl(
    private val api: TourInfoApi,
    private val dao: TourInfoDao
) : TourInfoRepository {

    override fun getTourInfo(): Flow<Resource<List<TourItem>>> = flow {
        emit(Resource.Loading())
        //first data get from database just in case data in cache
        val tourInfos: List<TourItem> = dao.getToursInfo().map { it.toToursModel() }
        emit(Resource.Loading(data = tourInfos))

        //make api request
        try {
            val remoteTourInfo = api.getTourList()
            dao.deleteTourInofs()
            dao.insertTourInfos(remoteTourInfo.map { it.toTourModelItem() })
        } catch (e: IOException) {
            emit(Resource.Error(message = "Oops, something went wrong", data = tourInfos))
        } catch (e: HttpException) {
            emit(Resource.Error(message = "Check your Internet Connection!", data = tourInfos))
        }

        val newTourInfos: List<TourItem> = dao.getToursInfo().map { it.toToursModel() }
        emit(Resource.Success(newTourInfos))
    }


}