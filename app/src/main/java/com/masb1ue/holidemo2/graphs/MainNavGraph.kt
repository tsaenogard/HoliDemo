package com.masb1ue.holidemo2.graphs

import androidx.compose.runtime.Composable
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
    viewModel: SearchViewModel
) {
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
                viewModel.getProductList()
                navController.navigate(BottomBarNav.Category.route)
            }, {
                navController.navigate(BottomBarNav.Product.route)
            })
        }
        composable(BottomBarNav.Category.route) {
            CategoryScreen(modifier,
                isLoading = false,
                productList = viewModel.productResponse,
                onProductClick = { product ->
                    navController.navigate(BottomBarNav.Product.route)
                })
        }
        composable(BottomBarNav.Product.route) {
            ProductScreen(modifier, SampleData.productList[0])
        }
        composable(BottomBarNav.Contact.route) {
            ContactScreen(modifier)
        }
        composable(BottomBarNav.My.route) {
            MyScreen(modifier)
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
        title = "HOME",
        icon = R.drawable.icon_gift
    )

    object Contact : BottomBarNav(
        route = "Contact",
        title = "Contact",
        icon = R.drawable.icon_support
    )

    object My : BottomBarNav(
        route = "My",
        title = "My",
        icon = R.drawable.icon_user
    )

    object Category : BottomBarNav(
        route = "Category",
        title = "Category",
        icon = R.drawable.icon_user
    )

    object Product : BottomBarNav(
        route = "Product",
        title = "Product",
        icon = R.drawable.icon_user
    )
}