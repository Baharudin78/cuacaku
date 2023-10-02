package com.baharudin.cuacaku.presentation.dashboard

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.baharudin.cuacaku.core.Screen
import com.baharudin.cuacaku.core.ui.component.ScreenBackground
import com.baharudin.cuacaku.presentation.dashboard.quake.QuakeUIState
import kotlinx.coroutines.flow.StateFlow

@Composable
fun DashboardScreen(
    dashboarState: StateFlow<QuakeUIState>
){
    val uiState by dashboarState.collectAsStateWithLifecycle()
    val context = LocalContext.current

//    ScreenBackground(
//        modifier = Modifier
//            .fillMaxSize()
//    ) {
//        when(uiState) {
//            is QuakeUIState.Loading -> Loading()
//            is QuakeUIState.Empty -> NoQuakeFound()
//            is QuakeUIState.Success -> {
//
//            }
//            is QuakeUIState.Fail -> {
//                NoQuakeFound()
//                LaunchedEffect(Unit) {
//                    Toast.makeText(
//                        context,
//                        (uiState as QuakeUIState.Fail).throwable.localizedMessage,
//                        Toast.LENGTH_LONG
//                    ).show()
//                }
//            }
//            else -> {}
//        }
//    }
}

@Composable
private fun Loading() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Loading...", modifier = Modifier
                .padding(16.dp)
                .align(Alignment.Center),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Composable
private fun NoQuakeFound() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "No quake found",
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.Center),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}