package com.baharudin.cuacaku.presentation.dashboard

import android.animation.PropertyValuesHolder
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.baharudin.cuacaku.domain.quake.usecase.QuakeUseCase
import com.baharudin.cuacaku.presentation.dashboard.quake.QuakeState
import com.baharudin.cuacaku.presentation.dashboard.quake.QuakeUIState
import com.baharudin.cuacaku.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val quakeUseCase : QuakeUseCase
) : ViewModel(){

    private var _quakeState : MutableStateFlow<QuakeUIState> = MutableStateFlow(QuakeUIState.Empty)
    val quakeState : StateFlow<QuakeUIState> = _quakeState.asStateFlow()

    init {
        getQuake()
    }

    private fun getQuake() {
        viewModelScope.launch {
            _quakeState.value = QuakeUIState.Loading
            try {
                quakeUseCase.getQuake().collect { result ->
                    _quakeState.value = result.data?.let { QuakeUIState.Success(it) }!!
                }
            }catch (e : Throwable) {
                _quakeState.value = QuakeUIState.Fail(e)
            }
        }
    }
}