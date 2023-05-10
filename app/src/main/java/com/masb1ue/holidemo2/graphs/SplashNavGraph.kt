package com.masb1ue.holidemo2.graphs

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.masb1ue.holidemo2.SplashScreen

fun NavGraphBuilder.splashNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.SPLASH,
        startDestination = SplashNav.Splash.route
    ) {
        composable(route = SplashNav.Splash.route) {
            SplashScreen(Modifier,
                onFinishSplash = {
                    navController.navigate(Graph.MAIN)
                })
        }
    }
}


sealed class SplashNav(val route: String) {
    object Splash : SplashNav(route = "SPLASH")
}