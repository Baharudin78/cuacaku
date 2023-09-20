package com.baharudin.cuacaku.core

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.baharudin.cuacaku.core.ext.navigateTo

fun NavGraphBuilder.homeNavGraph(onNavigateTpRoot: (Screen) -> Unit) {
    composable(
        route = Screen.Home.route
    ){
        val navController = rememberNavController()
        val navBackStackEntry by navController.currentBackStackEntryAsState()

        val bottomBar: @Composable () -> Unit = {
            HomeBottonNavigation(
                screen = listOf(

                ),
                onNavigationTo = navController::navigateTo,
                currentDestination = navBackStackEntry?.destination
            )
        }

        val nestedNavGraph : @Composable () -> Unit = {

        }
    }
}