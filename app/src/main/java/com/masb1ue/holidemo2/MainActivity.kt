package com.masb1ue.holidemo2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.masb1ue.holidemo2.api.ImageData
import com.masb1ue.holidemo2.api.SearchViewModel
import com.masb1ue.holidemo2.data.Product
import com.masb1ue.holidemo2.data.SampleData
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
                                subtitle = "BABA 美式輕食",
                                name = "環保純白包裝袋",
                                detail = "採用環保紙材，無有害化學物，符合環保要求、環境友好，為企業和消費者選擇綠色包裝的理想選擇",
                                cost = 23,
                                size = "large",
                                remark = "remark",
                                category1 = "食品",
                                category2 = "商品售賣",
                                image = listOf("https://api.waproject-gift.store/api/v1/static/3_1681371997.png")
                            )
                        )
                    }
                    val layerIndex = remember { mutableStateOf(0) }
                    DismissibleNavigationDrawer(
                        drawerState = drawerState,
                        drawerContent = {
                            DismissibleDrawerSheet() {
                                Column {
                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .height(64.dp),
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Image(
                                            painter = painterResource(id = R.drawable.icon_left),
                                            contentDescription = null,
                                            contentScale = ContentScale.FillHeight,
                                            modifier = Modifier
                                                .fillMaxHeight()
                                                .clickable {
                                                    scope.launch {
                                                        drawerState.close()
                                                    }
                                                }
                                        )
                                    }
                                    Spacer(Modifier.height(12.dp))
                                    LazyColumn(
                                        modifier = Modifier
                                            .fillMaxSize()
                                            .padding(start = 16.dp)
                                    ) {
                                        item {
                                            Box(
                                                modifier = Modifier.fillMaxWidth(),
                                                contentAlignment = Alignment.Center
                                            ) {
                                                Image(
                                                    painter = painterResource(id = R.drawable.group_industry),
                                                    contentDescription = null,
                                                    modifier = Modifier.fillMaxWidth(),
                                                    contentScale = ContentScale.FillWidth
                                                )
                                                Image(
                                                    painter = painterResource(id = R.drawable.cover),
                                                    contentDescription = null,
                                                    modifier = Modifier.fillMaxWidth(),
                                                    contentScale = ContentScale.FillWidth
                                                )
                                                Text(
                                                    text = "產業別",
                                                    fontSize = 16.sp,
                                                    color = MaterialTheme.colorScheme.inversePrimary
                                                )
                                            }
                                        }
                                        items(SampleData.categoryList.size) { index ->
                                            Row(
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                                    .height(73.dp)
                                                    .padding(start = 16.dp)
                                                    .clickable {
                                                        scope.launch {
                                                            drawerState.close()
                                                        }
                                                        categoryTitle.value =
                                                            SampleData.categoryList[index]
                                                        layerIndex.value = 1
                                                        viewModel.getProductList(
                                                            listOf(SampleData.categoryList[index]),
                                                            listOf()
                                                        )
                                                        navController.navigate("category")
                                                    },
                                                verticalAlignment = Alignment.CenterVertically
                                            ) {
                                                Text(
                                                    text = SampleData.categoryList[index],
                                                    fontSize = 16.sp,
                                                    modifier = Modifier.weight(1.0f)
                                                )
                                                Image(
                                                    painter = painterResource(id = R.drawable.icon_next),
                                                    contentDescription = null,
                                                    modifier = Modifier
                                                        .fillMaxHeight()
                                                        .aspectRatio(1.0f),
                                                )
                                            }
                                            Divider(modifier = Modifier.padding(end = 16.dp))
                                        }
                                        item {
                                            Box(
                                                modifier = Modifier.fillMaxWidth(),
                                                contentAlignment = Alignment.Center
                                            ) {
                                                Image(
                                                    painter = painterResource(id = R.drawable.group_usage),
                                                    contentDescription = null,
                                                    modifier = Modifier.fillMaxWidth(),
                                                    contentScale = ContentScale.FillWidth
                                                )
                                                Image(
                                                    painter = painterResource(id = R.drawable.cover),
                                                    contentDescription = null,
                                                    modifier = Modifier.fillMaxWidth(),
                                                    contentScale = ContentScale.FillWidth
                                                )
                                                Text(
                                                    text = "用途別",
                                                    fontSize = 16.sp,
                                                    color = MaterialTheme.colorScheme.inversePrimary
                                                )
                                            }
                                        }
                                        items(SampleData.usageList.size) { index ->
                                            Row(
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                                    .height(73.dp)
                                                    .padding(start = 32.dp)
                                                    .clickable {
                                                        scope.launch {
                                                            drawerState.close()
                                                        }
                                                        categoryTitle.value =
                                                            SampleData.usageList[index]
                                                        layerIndex.value = 1
                                                        viewModel.getProductList(
                                                            listOf(),
                                                            listOf(SampleData.usageList[index])
                                                        )
                                                        navController.navigate("category")
                                                    },
                                                verticalAlignment = Alignment.CenterVertically
                                            ) {
                                                Text(
                                                    text = SampleData.usageList[index],
                                                    fontSize = 16.sp,
                                                    modifier = Modifier.weight(1.0f)
                                                )
                                                Image(
                                                    painter = painterResource(id = R.drawable.icon_next),
                                                    contentDescription = null,
                                                    modifier = Modifier
                                                        .fillMaxHeight()
                                                        .aspectRatio(1.0f),
                                                )
                                            }
                                            Divider(modifier = Modifier.padding(end = 16.dp))
                                        }
                                    }
                                }
                            }
                        }
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Scaffold(
                                topBar = {
                                    CenterAlignedTopAppBar(
                                        title = {
                                            Text(
                                                text = "好禮",
                                                maxLines = 1,
                                                overflow = TextOverflow.Ellipsis
                                            )
                                        },
                                        navigationIcon = {
                                            IconButton(onClick = {
                                                if (layerIndex.value == 0) {
                                                    scope.launch { drawerState.open() }
                                                } else {
                                                    navController.popBackStack()
                                                    layerIndex.value -= 1
                                                }
                                            }) {
                                                Icon(
                                                    imageVector = if (layerIndex.value == 0) {
                                                        Icons.Filled.Menu
                                                    } else {
                                                        Icons.Filled.ArrowBack
                                                    },
                                                    contentDescription = null
                                                )
                                            }
                                        },
                                        actions = {
                                            IconButton(onClick = { /*TODO*/ }) {
                                                Icon(
                                                    imageVector = Icons.Filled.Notifications,
                                                    contentDescription = null
                                                )
                                            }
                                        }
                                    )
                                },
                                bottomBar = {
                                    var selectedItem by remember { mutableStateOf(0) }
                                    NavigationBar(
                                        containerColor = MaterialTheme.colorScheme.secondary
                                    ) {
                                        SampleData.naviList.forEachIndexed { index, item ->
                                            NavigationBarItem(
                                                icon = {
                                                    Icon(
                                                        Icons.Filled.Email,
                                                        contentDescription = item
                                                    )
                                                },
                                                label = {
                                                    Text(
                                                        item,
                                                        style = MaterialTheme.typography.bodySmall
                                                    )
                                                },
                                                selected = selectedItem == index,
                                                onClick = {
                                                    selectedItem = index
                                                    layerIndex.value = 0
                                                    navController.navigate(SampleData.naviRouteList[index])
                                                },
                                            )
                                        }
                                    }
                                }
                            ) { innerPadding ->
                                NavHost(
                                    navController = navController,
                                    startDestination = "home",
                                ) {
                                    composable("home") {
                                        HomeScreen(
                                            modifier = Modifier.padding(innerPadding),
                                            onCategoryClick = {
                                                categoryTitle.value = it
                                                layerIndex.value = 1
                                                viewModel.getProductList(
                                                    listOf(it),
                                                    usage = listOf()
                                                )
                                                navController.navigate("category")
                                            },
                                            onDemoClick = {
                                                layerIndex.value = 2
                                                navController.navigate("product")
                                            })
                                    }
                                    composable("category") {
                                        CategoryScreen(
                                            modifier = Modifier.padding(innerPadding),
                                            categoryTitle.value,
                                            productList = viewModel.productResponse,
                                            onProductClick = { product ->
                                                productTitle.value = product
                                                layerIndex.value = 2
                                                navController.navigate("product")
                                            })
                                    }
                                    composable("product") {
                                        ProductScreen(
                                            modifier = Modifier.padding(innerPadding),
                                            productTitle.value
                                        )
                                    }
                                    composable("contact") {
                                        ContactScreen(
                                            modifier = Modifier.padding(innerPadding),
                                        )
                                    }
                                    composable("my") {
                                        MyScreen(
                                            modifier = Modifier.padding(innerPadding),
                                        )
                                    }
                                }
                            }
                        }
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