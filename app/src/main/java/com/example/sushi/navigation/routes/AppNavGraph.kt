package com.example.sushi.navigation.routes


import ProductListScreen
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.sushi.features.cart.CartScreen
import com.example.sushi.features.home.ProductViewModel
import com.example.sushi.features.product_detail.ProductDetailScreen

@Composable
fun AppNavGraph(navController: NavHostController) {
    Scaffold(
        bottomBar = { BottomBar(navController) }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Routes.HOME
        ) {
            composable(Routes.HOME) {
                ProductListScreen(navController)
            }
            composable(Routes.CART) {
                CartScreen(navController)
            }
            composable("${Routes.PRODUCT_DETAIL}/{productId}") { backStackEntry ->
                val productId = backStackEntry.arguments?.getString("productId")?.toInt()
                val viewModel: ProductViewModel = viewModel()
                val product = viewModel.products.value.find { it.id ==productId }
                ProductDetailScreen(product, navController)
            }
        }
    }

}

