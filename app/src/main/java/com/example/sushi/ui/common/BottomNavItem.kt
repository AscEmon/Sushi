package com.example.sushi.ui.common

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.sushi.navigation.routes.Routes

data class BottomNavItem(
    val title: String,
    val route: String,
    val icon: ImageVector,
)


val bottomNavItems = listOf(
    BottomNavItem(Routes.HOME, "Home", Icons.Filled.Home),
    BottomNavItem(Routes.CART, "Cart", Icons.Filled.ShoppingCart)
)