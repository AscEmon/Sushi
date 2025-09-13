package com.example.sushi.ui.common

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavController


@Composable
fun BaseScreen(title: String,
               navController: NavController,
               showBackButton: Boolean = navController.previousBackStackEntry != null,
               content: @Composable (PaddingValues) -> Unit
               ) {
    Scaffold (
        topBar  = {
            AppToolBar(title = title,navController = navController,showBackButton =showBackButton)
        }
    )  { innerPadding ->
            content(innerPadding)
        }

}