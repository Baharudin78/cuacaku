package com.baharudin.cuacaku.core

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import com.baharudin.cuacaku.core.ui.component.AppBottomBar
import com.baharudin.cuacaku.core.ui.component.AppBottomBarItem

@Composable
fun HomeBottonNavigation(
    screen: List<Screen>,
    onNavigationTo : (Screen) -> Unit,
    currentDestination : NavDestination?
){
    AnimatedVisibility(
        visible = true,
        enter = slideInHorizontally(initialOffsetX = { it }),
        exit = slideOutHorizontally(targetOffsetX = { it })
    ) {
        AppBottomBar {
            screen.forEach { screen ->
                val selected: Boolean =
                    currentDestination?.hierarchy?.any { it.route == screen.route } ?: false
                AppBottomBarItem(selected = selected, onClick = { onNavigationTo(screen) }, icon = {
                    Icon(
                        imageVector = screen.icon ?: Icons.Default.Warning,
                        contentDescription = null
                    )
                }, label = { Text(text = screen.title ?: "") })
            }
        }
    }
}