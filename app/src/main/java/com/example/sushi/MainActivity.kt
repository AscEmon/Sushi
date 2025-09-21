package com.example.sushi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.sushi.features.cart.CartViewModel
import com.example.sushi.navigation.routes.AppNavGraph


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            // ✅ Single instance shared everywhere
            val cartViewModel: CartViewModel = viewModel()

            AppNavGraph(navController = navController, cartViewModel = cartViewModel)
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    val navController = rememberNavController()
    val cartViewModel: CartViewModel = viewModel()
    AppNavGraph(navController =navController,cartViewModel)

}