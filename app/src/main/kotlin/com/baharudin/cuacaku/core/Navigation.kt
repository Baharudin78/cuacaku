package com.baharudin.cuacaku.core

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.baharudin.cuacaku.core.ext.navigateTo
import com.baharudin.cuacaku.core.navigation.HomeNavGraph
import com.baharudin.cuacaku.presentation.dashboard.DashboardScreen
import com.baharudin.cuacaku.presentation.dashboard.DashboardViewModel
import com.baharudin.cuacaku.presentation.forecast.ForecastScreen
import com.baharudin.cuacaku.presentation.home.HomeScreen

fun NavGraphBuilder.homeNavGraph(onNavigateTpRoot: (Screen) -> Unit) {
    composable(
        route = Screen.Home.route
    ) {
        val navController = rememberNavController()
        val navBackStackEntry by navController.currentBackStackEntryAsState()

        val bottomBar: @Composable () -> Unit = {
            HomeBottonNavigation(
                screen = listOf(
                    Screen.Dashboard,
                    Screen.Forecast
                ),
                onNavigationTo = navController::navigateTo,
                currentDestination = navBackStackEntry?.destination
            )
        }

        val nestedNavGraph: @Composable () -> Unit = {
            HomeNavGraph(navHostController = navController, onNavigateToRoot = onNavigateTpRoot)
        }

        HomeScreen(nestedNavGraph = nestedNavGraph, bottomBar = bottomBar)
    }
}

fun NavGraphBuilder.dashboardScreen() {
    composable(
        route = Screen.Dashboard.route
    ){
        val dashboardViewModel : DashboardViewModel = viewModel()
        DashboardScreen(
            dashboardViewModel.quakeState
        )
    }
}

fun NavGraphBuilder.forecastScreen() {
    composable(
        route = Screen.Forecast.route
    ){
        ForecastScreen()
    }
}