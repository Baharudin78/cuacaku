package com.baharudin.cuacaku.presentation.home

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.baharudin.cuacaku.core.ui.component.ScreenBackground

@Composable
fun HomeScreen(
    nestedNavGraph : @Composable () -> Unit,
    bottomBar : @Composable () -> Unit
){
    Scaffold(
        bottomBar = bottomBar,
        contentWindowInsets = WindowInsets(left = 0, top = 0, right = 0, bottom = 0)
    ) { paddingValues ->
        ScreenBackground(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            nestedNavGraph.invoke()
        }
    }
}