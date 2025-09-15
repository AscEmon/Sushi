package com.example.sushi.features.cart



import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.sushi.ui.common.BaseScreen

@Composable
fun CartScreen(navController: NavController) {
    BaseScreen(title = "Cart",navController,showBackButton = false, content = { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            Text("Your cart is empty 🛒")
        }
    })
}
