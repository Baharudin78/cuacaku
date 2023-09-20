package com.baharudin.cuacaku.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.baharudin.cuacaku.core.Screen

@Composable
fun HomeNavGraph(
    modifier : Modifier = Modifier,
    navHostController: NavHostController,
    onNavigateToRoot : (Screen) -> Unit
){
    NavHost(
        navController = navHostController,
        startDestination = Screen.Home.route,
        modifier = modifier
    ) {
        // TODO : Adding screen here for bottom nav screen
    }
}