package com.masb1ue.holidemo2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.masb1ue.holidemo2.api.SearchViewModel
import com.masb1ue.holidemo2.data.Product
import com.masb1ue.holidemo2.data.SampleData
import com.masb1ue.holidemo2.graphs.RootNavigationGraph
import com.masb1ue.holidemo2.ui.theme.HoliDemo2Theme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    val viewModel by viewModels<SearchViewModel>()

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HoliDemo2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    val scope = rememberCoroutineScope()
                    val drawerState = rememberDrawerState(DrawerValue.Closed)
                    val categoryTitle = remember { mutableStateOf("食品包裝") }
                    val productTitle = remember {
                        mutableStateOf(
                            Product(
                                id = 3,
                                priority = 1,
                                subtitle = "BABA 美式輕食",
                                name = "環保純白包裝袋",
                                content = "採用環保紙材，無有害化學物，符合環保要求、環境友好，為企業和消費者選擇綠色包裝的理想選擇",
                                cost = "23",
                                size = "large",
                                style = "",
                                category = listOf(),
                                imageData = listOf()
                            )
                        )
                    }
                    val layerIndex = remember { mutableStateOf(0) }
                    val isShowFilter = viewModel.isShowFilter
                    ModalNavigationDrawer(
                        drawerState = drawerState,
                        drawerContent = {
                            ModalDrawerSheet(drawerShape = RoundedCornerShape(0.dp)) {
                                DrawerScreen(
                                    Modifier,
                                    {
                                        viewModel.setUsage("全部")
                                        viewModel.setIndustry("全部")
                                        viewModel.getProductList()
                                        navController.navigate("category")
                                        layerIndex.value = 1
                                        scope.launch {
                                            drawerState.close()
                                        }
                                    },
                                    {
                                        viewModel.getProductList()
                                        navController.navigate("category")
                                        layerIndex.value = 1
                                        scope.launch {
                                            drawerState.close()
                                        }
                                    },
                                    {
                                        viewModel.setUsage("全部")
                                        viewModel.setIndustry("全部")
                                    },
                                    if (viewModel.industryList.size == SampleData.industryList.size) {
                                        listOf("全部")
                                    } else {
                                        viewModel.industryList
                                    },
                                    if (viewModel.usageList.size == SampleData.usageList.size) {
                                        listOf("全部")
                                    } else {
                                        viewModel.usageList
                                    },
                                    { viewModel.setIndustry(it) },
                                    { viewModel.setUsage(it) }
                                )
                            }
                        }
                    ) {
                        RootNavigationGraph(navController = navController, viewModel)
//                        Column(
//                            modifier = Modifier
//                                .fillMaxSize(),
//                            horizontalAlignment = Alignment.CenterHorizontally
//                        ) {
//                            Scaffold(
//                                topBar = {
//                                    CenterAlignedTopAppBar(
//                                        title = {
//                                            Image(
//                                                painter = painterResource(id = R.drawable.logo),
//                                                contentDescription = null,
//                                                modifier = Modifier.height(28.dp)
//                                            )
//                                        },
//                                        navigationIcon = {
//                                            if (layerIndex.value != 0) {
//                                                IconButton(onClick = {
//                                                    navController.popBackStack()
//                                                    layerIndex.value -= 1
//                                                }) {
//                                                    Image(
//                                                        painter = painterResource(id = R.drawable.icon_left),
//                                                        contentDescription = null,
//                                                        modifier = Modifier
//                                                            .size(48.dp, 48.dp)
//                                                    )
//                                                }
//                                            }
//                                        },
//                                        actions = {
//                                            if (isShowFilter.value) {
//                                                IconButton(onClick = { scope.launch { drawerState.open() } }) {
////
//                                                    Image(
//                                                        painter = painterResource(id = R.drawable.icon_menu),
//                                                        contentDescription = null,
//                                                        modifier = Modifier.size(48.dp, 48.dp)
//                                                    )
//                                                }
//                                            }
//                                        },
//                                    )
//                                },
//                                bottomBar = {
//                                    var selectedItem by remember { mutableStateOf(0) }
//                                    NavigationBar(
//                                        containerColor = MaterialTheme.colorScheme.secondary
//                                    ) {
//                                        SampleData.naviList.forEachIndexed { index, item ->
//                                            NavigationBarItem(
//                                                icon = {
//                                                    Image(
//                                                        painter = painterResource(id = SampleData.naviIconList[index]),
//                                                        contentDescription = null,
//                                                        modifier = Modifier.size(24.dp)
//                                                    )
//                                                },
//                                                label = {
//                                                    Text(
//                                                        item,
//                                                        style = MaterialTheme.typography.bodySmall,
//                                                        color = MaterialTheme.colorScheme.onSecondary
//                                                    )
//                                                },
//                                                selected = selectedItem == index,
//                                                onClick = {
//                                                    isShowFilter.value = index == 0
//                                                    selectedItem = index
//                                                    layerIndex.value = 0
//                                                    navController.navigate(SampleData.naviRouteList[index])
//                                                },
//                                            )
//                                        }
//                                    }
//                                }
//                            ) { innerPadding ->
//                                NavHost(
//                                    navController = navController,
//                                    startDestination = "home",
//                                ) {
//                                    composable("home") {
//                                        HomeScreen(
//                                            modifier = Modifier.padding(innerPadding),
//                                            onCategoryClick = {
//                                                categoryTitle.value = it
//                                                layerIndex.value = 1
//                                                viewModel.setIndustry("全部")
//                                                viewModel.setUsage("全部")
//                                                viewModel.setIndustry(it)
//                                                viewModel.getProductList()
//                                                navController.navigate("category")
//                                            },
//                                            onDemoClick = {
//                                                layerIndex.value = 2
//                                                navController.navigate("product")
//                                            })
//                                    }
//                                    composable("category") {
//                                        CategoryScreen(
//                                            modifier = Modifier.padding(innerPadding),
//                                            viewModel.isLoading,
//                                            productList = viewModel.productResponse,
//                                            onProductClick = { product ->
//                                                productTitle.value = product
//                                                layerIndex.value = 2
//                                                navController.navigate("product")
//                                            })
//                                    }
//                                    composable("product") {
//                                        ProductScreen(
//                                            modifier = Modifier.padding(innerPadding),
//                                            productTitle.value
//                                        )
//                                    }
//                                    composable("contact") {
//                                        ContactScreen(
//                                            modifier = Modifier.padding(innerPadding),
//                                        )
//                                    }
//                                    composable("my") {
//                                        MyScreen(
//                                            modifier = Modifier.padding(innerPadding),
//                                        )
//                                    }
//                                }
//                            }
//                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    HoliDemo2Theme {
        Greeting("Android")
    }
}