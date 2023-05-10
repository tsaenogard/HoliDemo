package com.masb1ue.holidemo2.graphs

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.masb1ue.holidemo2.MainScreen
import com.masb1ue.holidemo2.api.SearchViewModel

@Composable
fun RootNavigationGraph(navController: NavHostController, viewModel: SearchViewModel) {
    NavHost(
        navController = navController,
        route = Graph.ROOT,
        startDestination = Graph.SPLASH
    ) {
        splashNavGraph(navController = navController)
        composable(route = Graph.MAIN) {
            MainScreen(Modifier, viewModel = viewModel)
        }
    }
}

object Graph {
    const val ROOT = "root_graph"
    const val SPLASH = "splash_graph"
    const val MAIN = "main_graph"
}