package com.baharudin.cuacaku.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.baharudin.cuacaku.core.Graph
import com.baharudin.cuacaku.core.Screen
import com.baharudin.cuacaku.core.ext.navigateTo
import com.baharudin.cuacaku.core.homeNavGraph

@Composable
fun RootNavGraph(
    navController : NavHostController,
    modifier : Modifier = Modifier,
    startDestination : Screen
){
    NavHost(
        navController = navController,
        startDestination = startDestination.route,
        route = Graph.ROOT_GRAPH,
        modifier = modifier
    ) {
        val navigateBack : () -> Unit = {
            navController.navigateUp()
        }

        homeNavGraph(onNavigateTpRoot = navController::navigateTo)
    }
}