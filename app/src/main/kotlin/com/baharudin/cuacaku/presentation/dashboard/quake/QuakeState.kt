package com.baharudin.cuacaku.presentation.dashboard.quake

import com.baharudin.cuacaku.domain.quake.model.QuakeEntity

data class QuakeState(
    val quakeData : QuakeEntity? = null,
    val isLoading : Boolean = false,
    val error : String? = null,
)
