package com.baharudin.cuacaku.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.baharudin.cuacaku.core.Graph
import com.baharudin.cuacaku.core.Screen

@Composable
fun RootNavGraph(
    navController : NavHostController,
){
    NavHost(
        navController = navController,
        startDestination = Graph.HOME_GRAPH,
        route = Graph.ROOT_GRAPH,
    ) {
        val navigateBack : () -> Unit = {
            navController.navigateUp()
        }

    }
}