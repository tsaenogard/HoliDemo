package com.masb1ue.holidemo2

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.masb1ue.holidemo2.api.SearchViewModel
import com.masb1ue.holidemo2.graphs.BottomBarNav
import com.masb1ue.holidemo2.graphs.MainNavGraph

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    modifier: Modifier,
    navController: NavHostController = rememberNavController(),
    viewModel: SearchViewModel,
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    val navBackStackEntry by navController.currentBackStackEntryAsState()
                    when (navBackStackEntry?.destination?.route) {
                        BottomBarNav.Category.route,
                        BottomBarNav.Product.route,
                        BottomBarNav.Home.route ->
                            Image(
                                painter = painterResource(id = R.drawable.logo),
                                contentDescription = null,
                                modifier = Modifier.height(28.dp)
                            )
                        else -> {}
                    }

                },
                navigationIcon = {
                    val navBackStackEntry by navController.currentBackStackEntryAsState()
                    when (navBackStackEntry?.destination?.route) {
                        BottomBarNav.Category.route,
                        BottomBarNav.Product.route,
                        BottomBarNav.Filter.route,
                        BottomBarNav.FilterResult.route ->
                            if (!viewModel.isLoading) {
                                IconButton(onClick = {
                                    navController.popBackStack()
                                }) {
                                    Image(
                                        painter = painterResource(id = R.drawable.icon_left),
                                        contentDescription = null,
                                        modifier = Modifier
                                            .size(48.dp, 48.dp)
                                    )
                                }
                            } else {
                                IconButton(onClick = {}) {}
                            }
                        else -> IconButton(onClick = {}) {}
                    }
                },
            )
        },
        bottomBar = {
            BottomBar(navController = navController)
        },
    ) { innerPadding ->
        MainNavGraph(navController = navController,
            modifier = Modifier.padding(innerPadding),
            viewModel = viewModel,
            onFilterClick = {
                navController.navigate(BottomBarNav.Filter.route)
            })
    }
}

@Composable
fun BottomBar(navController: NavHostController) {
    val screens = listOf(
        BottomBarNav.Home,
        BottomBarNav.Contact,
        BottomBarNav.My,
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    val bottomBarDestination = screens.any { it.route == currentDestination?.route }
    if (bottomBarDestination) {
        NavigationBar(
            containerColor = MaterialTheme.colorScheme.secondary,
        ) {
            screens.forEach { screen ->
                NavigationBarItem(
                    selected = currentDestination?.hierarchy?.any {
                        it.route == screen.route
                    } == true,
                    onClick = {
                        navController.navigate(screen.route) {
                            popUpTo(navController.graph.findStartDestination().id)
                            launchSingleTop = true
                        }
                    },
                    icon = {
                        Image(
                            painter = painterResource(id = screen.icon),
                            contentDescription = null,
                            modifier = Modifier.size(24.dp)
                        )
                    },
                    label = {
                        Text(
                            screen.title,
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSecondary
                        )
                    },
                )
            }
        }
    }
}