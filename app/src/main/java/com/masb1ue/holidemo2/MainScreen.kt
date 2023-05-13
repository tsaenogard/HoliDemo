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
//    val drawerState = rememberDrawerState(DrawerValue.Closed)
//    val scope = rememberCoroutineScope()
//    ModalNavigationDrawer(drawerState = drawerState, drawerContent = {
//        ModalDrawerSheet(drawerShape = RoundedCornerShape(0.dp)) {
//            DrawerScreen(Modifier,
//                onBackClick = {
//                    viewModel.setUsage("全部")
//                    viewModel.setIndustry("全部")
//                    viewModel.getProductList()
//                    navController.navigate(BottomBarNav.Category.route)
//                    scope.launch {
//                        drawerState.close()
//                    }
//                }, onConfirmClick = {
//                    viewModel.getProductList()
//                    navController.navigate("category")
//                    scope.launch {
//                        drawerState.close()
//                    }
//                }, onResetClick = {
//                    viewModel.setUsage("全部")
//                    viewModel.setIndustry("全部")
//                }, industry = if (viewModel.industryList.size == SampleData.industryList.size) {
//                    listOf("全部")
//                } else {
//                    viewModel.industryList
//                }, usage = if (viewModel.usageList.size == SampleData.usageList.size) {
//                    listOf("全部")
//                } else {
//                    viewModel.usageList
//                }, onIndustryCheck = {
//                    viewModel.setIndustry(it)
//                }, onUsageCheck = {
//                    viewModel.setUsage(it)
//                })
//        }
//    }) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Image(
                        painter = painterResource(id = R.drawable.logo),
                        contentDescription = null,
                        modifier = Modifier.height(28.dp)
                    )
                },
                navigationIcon = {
                    val navBackStackEntry by navController.currentBackStackEntryAsState()
                    when (navBackStackEntry?.destination?.route) {
                        BottomBarNav.Category.route,
                        BottomBarNav.Product.route ->
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
//    }
//    Scaffold(
//        topBar = {
//            CenterAlignedTopAppBar(
//                title = {
//                    Image(
//                        painter = painterResource(id = R.drawable.logo),
//                        contentDescription = null,
//                        modifier = Modifier.height(28.dp)
//                    )
//                },
//                navigationIcon = {
//                    if (layerIndex.value != 0) {
//                        IconButton(onClick = {
//                            navController.popBackStack()
//                            layerIndex.value -= 1
//                        }) {
//                            Image(
//                                painter = painterResource(id = R.drawable.icon_left),
//                                contentDescription = null,
//                                modifier = Modifier
//                                    .size(48.dp, 48.dp)
//                            )
//                        }
//                    }
//                },
//                actions = {
//                    if (isShowFilter.value) {
//                        IconButton(onClick = { scope.launch { drawerState.open() } }) {
////
//                            Image(
//                                painter = painterResource(id = R.drawable.icon_menu),
//                                contentDescription = null,
//                                modifier = Modifier.size(48.dp, 48.dp)
//                            )
//                        }
//                    }
//                },
//            )
//        },
//        bottomBar = {
//            var selectedItem by remember { mutableStateOf(0) }
//            NavigationBar(
//                containerColor = MaterialTheme.colorScheme.secondary
//            ) {
//                SampleData.naviList.forEachIndexed { index, item ->
//                    NavigationBarItem(
//                        icon = {
//                            Image(
//                                painter = painterResource(id = SampleData.naviIconList[index]),
//                                contentDescription = null,
//                                modifier = Modifier.size(24.dp)
//                            )
//                        },
//                        label = {
//                            Text(
//                                item,
//                                style = MaterialTheme.typography.bodySmall,
//                                color = MaterialTheme.colorScheme.onSecondary
//                            )
//                        },
//                        selected = selectedItem == index,
//                        onClick = {
//                            isShowFilter.value = index == 0
//                            selectedItem = index
//                            layerIndex.value = 0
//                            navController.navigate(SampleData.naviRouteList[index])
//                        },
//                    )
//                }
//            }
//        }
//    ) { innerPadding ->
//        NavHost(
//            navController = navController,
//            startDestination = "home",
//        ) {
//            composable("home") {
//                HomeScreen(
//                    modifier = Modifier.padding(innerPadding),
//                    onCategoryClick = {
//                        categoryTitle.value = it
//                        layerIndex.value = 1
//                        viewModel.setIndustry("全部")
//                        viewModel.setUsage("全部")
//                        viewModel.setIndustry(it)
//                        viewModel.getProductList()
//                        navController.navigate("category")
//                    },
//                    onDemoClick = {
//                        layerIndex.value = 2
//                        navController.navigate("product")
//                    })
//            }
//            composable("category") {
//                CategoryScreen(
//                    modifier = Modifier.padding(innerPadding),
//                    viewModel.isLoading,
//                    productList = viewModel.productResponse,
//                    onProductClick = { product ->
//                        productTitle.value = product
//                        layerIndex.value = 2
//                        navController.navigate("product")
//                    })
//            }
//            composable("product") {
//                ProductScreen(
//                    modifier = Modifier.padding(innerPadding),
//                    productTitle.value
//                )
//            }
//            composable("contact") {
//                ContactScreen(
//                    modifier = Modifier.padding(innerPadding),
//                )
//            }
//            composable("my") {
//                MyScreen(
//                    modifier = Modifier.padding(innerPadding),
//                )
//            }
//        }
//    }
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
            containerColor = MaterialTheme.colorScheme.secondary
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