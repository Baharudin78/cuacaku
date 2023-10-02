package com.baharudin.cuacaku.data.quake.remote

import com.baharudin.cuacaku.data.common.WrappedResponse
import com.baharudin.cuacaku.data.quake.dto.QuakeResponse
import com.baharudin.cuacaku.utils.Constant
import retrofit2.Response
import retrofit2.http.GET

interface QuakeApi {
    @GET(Constant.QUAKE_ENDPOINT)
    suspend fun getQuake() : WrappedResponse<QuakeResponse>
}