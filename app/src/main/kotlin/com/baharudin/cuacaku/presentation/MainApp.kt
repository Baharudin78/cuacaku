package com.baharudin.cuacaku.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.baharudin.cuacaku.core.Screen
import com.baharudin.cuacaku.core.navigation.RootNavGraph

@Composable
fun MainApp(){
    val navController = rememberNavController()
    RootNavGraph(navController = navController, startDestination = Screen.Home)
}