package com.baharudin.cuacaku.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.getValue
import androidx.core.view.WindowCompat
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.baharudin.cuacaku.presentation.ui.theme.AppTheme
import com.baharudin.cuacaku.presentation.ui.theme.darkModeState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            val darkMode by darkModeState.collectAsStateWithLifecycle()
            AppTheme(darkTheme = darkMode) {
                MainApp()
            }
        }
    }
}