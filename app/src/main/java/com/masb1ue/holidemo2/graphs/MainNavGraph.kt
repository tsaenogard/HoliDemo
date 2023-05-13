package com.masb1ue.holidemo2.graphs

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.masb1ue.holidemo2.*
import com.masb1ue.holidemo2.api.SearchViewModel
import com.masb1ue.holidemo2.data.SampleData

@Composable
fun MainNavGraph(
    navController: NavHostController,
    modifier: Modifier,
    viewModel: SearchViewModel,
    onFilterClick: (Boolean) -> Unit
) {
    val productItem = remember { mutableStateOf(SampleData.sampleProduct) }
    val categoryIndex = remember { mutableStateOf(0) }
    NavHost(
        navController = navController,
        route = Graph.MAIN,
        startDestination = BottomBarNav.Home.route
    ) {
        composable(BottomBarNav.Home.route) {
            HomeScreen(modifier, {
                viewModel.setIndustry("全部")
                viewModel.setUsage("全部")
                viewModel.setIndustry(it)
                categoryIndex.value = SampleData.industryTitleList.indexOf(it)
                viewModel.getProductList()
                navController.navigate(BottomBarNav.Category.route)
            }, { product ->
                productItem.value = product
                navController.navigate(BottomBarNav.Product.route)
            }, {
                onFilterClick(it)
            }
            )
        }
        composable(BottomBarNav.Category.route) {
            CategoryScreen(modifier,
                isLoading = viewModel.isLoading,
                categoryIndex = categoryIndex.value,
                productList = viewModel.productResponse,
                onProductClick = { product ->
                    productItem.value = product
                    navController.navigate(BottomBarNav.Product.route)
                })
        }
        composable(BottomBarNav.Product.route) {
            ProductScreen(modifier, productItem.value)
        }
        composable(BottomBarNav.Contact.route) {
            ContactScreen(modifier)
        }
        composable(BottomBarNav.My.route) {
            MyScreen(modifier)
        }
        composable(BottomBarNav.Filter.route) {
            DrawerScreen(modifier,
                onBackClick = {
                    viewModel.setUsage("全部")
                    viewModel.setIndustry("全部")
                    navController.navigate(BottomBarNav.Home.route)
                }, onConfirmClick = {
                    viewModel.getProductList()
                    navController.navigate(BottomBarNav.FilterResult.route)
                }, onResetClick = {
                    viewModel.setUsage("全部")
                    viewModel.setIndustry("全部")
                }, industry = if (viewModel.industryList.size == SampleData.industryList.size) {
                    listOf("全部")
                } else {
                    viewModel.industryList
                }, usage = if (viewModel.usageList.size == SampleData.usageList.size) {
                    listOf("全部")
                } else {
                    viewModel.usageList
                }, onIndustryCheck = {
                    viewModel.setIndustry(it)
                }, onUsageCheck = {
                    viewModel.setUsage(it)
                })
        }
        composable(BottomBarNav.FilterResult.route) {
            FilterResult(
                modifier = modifier,
                viewModel = viewModel,
                onBackClick = { navController.navigate(BottomBarNav.Home.route) },
                onResetClick = {
                    viewModel.setUsage("全部")
                    viewModel.setIndustry("全部")
                    navController.navigate(BottomBarNav.Filter.route)
                },
                productList = viewModel.productResponse,
                onProductClick = { product ->
                    productItem.value = product
                    navController.navigate(BottomBarNav.Product.route)
                }
            )
        }
    }
}

sealed class BottomBarNav(
    val route: String,
    val title: String,
    val icon: Int
) {
    object Home : BottomBarNav(
        route = "HOME",
        title = "首頁",
        icon = R.drawable.icon_gift
    )

    object Contact : BottomBarNav(
        route = "Contact",
        title = "聯絡",
        icon = R.drawable.icon_support
    )

    object My : BottomBarNav(
        route = "My",
        title = "關於",
        icon = R.drawable.icon_user
    )

    object Category : BottomBarNav(
        route = "Category",
        title = "作品集",
        icon = R.drawable.icon_user
    )

    object Product : BottomBarNav(
        route = "Product",
        title = "詳細頁",
        icon = R.drawable.icon_user
    )

    object Filter : BottomBarNav(
        route = "Filter",
        title = "篩選頁",
        icon = R.drawable.icon_user
    )

    object FilterResult : BottomBarNav(
        route = "FilterResult",
        title = "篩選結果頁",
        icon = R.drawable.icon_user
    )
}