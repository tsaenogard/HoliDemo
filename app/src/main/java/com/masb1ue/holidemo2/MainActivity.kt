package com.masb1ue.holidemo2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.masb1ue.holidemo2.api.SearchViewModel
import com.masb1ue.holidemo2.data.Product
import com.masb1ue.holidemo2.graphs.RootNavigationGraph
import com.masb1ue.holidemo2.ui.theme.HoliDemo2Theme

class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<SearchViewModel>()

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
                                remark = "",
                                category = listOf(),
                                imageData = listOf()
                            )
                        )
                    }
                    val layerIndex = remember { mutableStateOf(0) }
                    val isShowFilter = remember {
                        mutableStateOf(false)
                    }
                    RootNavigationGraph(navController = navController, viewModel)
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