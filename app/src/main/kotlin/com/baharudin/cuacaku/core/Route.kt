package com.baharudin.cuacaku.core

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.ui.graphics.vector.ImageVector


sealed class Screen(
    val route: String,
    var routePath: String? = null,
    var clearBackStack: Boolean = false,
    val restoreState: Boolean = true,
    val title: String? = null,
    val icon: ImageVector? = null
) {

    fun withClearBackStack() = apply { clearBackStack = true }

    fun routeWith(path: String) = apply {
        routePath = path
    }
    object Home : Screen(Graph.NAVIGATION_ROUTE_HOME)
    object Dashboard : Screen(Graph.NAVIGATION_DASHBOARD, title = "Dashboard", icon = Icons.Rounded.Home)
    object Forecast : Screen(Graph.NAVIGATION_ROUTE_FORECAST, title = "Forecast", icon = Icons.Rounded.Menu)


}

object Graph {
    const val ROOT_GRAPH = "root_graph"
    const val HOME_GRAPH = "home_graph"
    const val NAVIGATION_ROUTE_HOME = "home"
    const val NAVIGATION_DASHBOARD = "dashboard"
    const val NAVIGATION_ROUTE_FORECAST = "forecast"
}
