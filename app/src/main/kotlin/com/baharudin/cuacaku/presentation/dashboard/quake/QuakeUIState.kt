package com.baharudin.cuacaku.presentation.dashboard.quake

import com.baharudin.cuacaku.domain.quake.model.QuakeEntity

sealed interface QuakeUIState {

        object Empty : QuakeUIState

        object Loading : QuakeUIState

        class Success(val profileList : QuakeEntity) : QuakeUIState

        class Fail(val throwable: Throwable) : QuakeUIState

}