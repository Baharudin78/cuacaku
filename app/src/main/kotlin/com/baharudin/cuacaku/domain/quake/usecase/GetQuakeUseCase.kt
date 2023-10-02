package com.baharudin.cuacaku.domain.quake.usecase

import com.baharudin.cuacaku.domain.quake.model.QuakeEntity
import com.baharudin.cuacaku.domain.quake.repository.QuakeRepository
import com.baharudin.cuacaku.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetQuakeUseCase @Inject constructor(
    private val quakeRepository: QuakeRepository
) {
    operator fun invoke() : Flow<Resource<QuakeEntity>> {
        return flow {
            emit(Resource.Loading())
            quakeRepository.getQuake().collect { result ->
                when(result) {
                    is Resource.Success -> {
                        result.data?.let {
                            emit(Resource.Success(it))
                        }
                    }
                    is Resource.Error -> {
                        emit(Resource.Error(result.message ?: "Unknown error"))
                    }
                    else -> {}
                }
            }
        }
    }
}