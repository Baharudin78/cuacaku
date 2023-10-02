package com.baharudin.cuacaku.domain.quake.repository

import com.baharudin.cuacaku.domain.quake.model.QuakeEntity
import com.baharudin.cuacaku.utils.Resource
import kotlinx.coroutines.flow.Flow

interface QuakeRepository {
    suspend fun getQuake() : Flow<Resource<QuakeEntity>>
}