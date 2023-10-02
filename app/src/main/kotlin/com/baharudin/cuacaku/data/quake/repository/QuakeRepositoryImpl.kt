package com.baharudin.cuacaku.data.quake.repository

import android.os.Build
import androidx.annotation.RequiresExtension
import com.baharudin.cuacaku.data.quake.mapper.toQuakeEntity
import com.baharudin.cuacaku.data.quake.remote.QuakeApi
import com.baharudin.cuacaku.domain.quake.model.QuakeEntity
import com.baharudin.cuacaku.domain.quake.repository.QuakeRepository
import com.baharudin.cuacaku.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class QuakeRepositoryImpl @Inject constructor(
    private val quakeApi : QuakeApi
) : QuakeRepository{
    override suspend fun getQuake(): Flow<Resource<QuakeEntity>> = flow{
        try {
            emit(Resource.Loading())
            val quake = quakeApi.getQuake().data?.toQuakeEntity()
            emit(Resource.Success(quake))
        }catch (e : HttpException){
            emit(Resource.Error(e.localizedMessage ?: "Unexpected error"))
        }catch (e : IOException){
            emit(Resource.Error("Couldn't reach server. Check your internet connection"))
        }
    }

}