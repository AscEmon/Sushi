package com.example.sushi.navigation.routes


import ProductListScreen
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.sushi.features.cart.CartScreen
import com.example.sushi.features.cart.CartViewModel
import com.example.sushi.features.home.ProductViewModel
import com.example.sushi.features.product_detail.ProductDetailScreen

@Composable
fun AppNavGraph(
    navController: NavHostController,
    cartViewModel: CartViewModel // ✅ Inject from MainActivity
) {
    Scaffold(
        bottomBar = { BottomBar(navController) }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Routes.HOME,
            modifier = Modifier.padding(innerPadding) // ✅ fixes layout issue
        ) {

            composable(Routes.HOME) {
                val productViewModel: ProductViewModel = viewModel()
                ProductListScreen(navController, productViewModel, cartViewModel)
            }

            composable(Routes.CART) {
                CartScreen(navController, cartViewModel)
            }

            composable("${Routes.PRODUCT_DETAIL}/{productId}") { backStackEntry ->
                val productId = backStackEntry.arguments?.getString("productId")?.toInt()
                val productViewModel: ProductViewModel = viewModel()
                val product = productViewModel.products.value.find { it.id == productId }

                // ✅ Pass cartViewModel + safe product
                product?.let {
                    ProductDetailScreen(it, navController, cartViewModel)
                }
            }
        }
    }
}

