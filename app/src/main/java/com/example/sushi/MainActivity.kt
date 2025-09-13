package com.example.sushi

import ProductListScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.sushi.features.home.ProductViewModel
import com.example.sushi.ui.theme.SushiTheme
import androidx.lifecycle.viewmodel.compose.viewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SushiTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainContent()
                }
            }
        }
    }
}



@Composable
fun MainContent() {
    val viewModel: ProductViewModel = viewModel()
    ProductListScreen(viewModel)
}




@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SushiTheme {
        MainContent()
    }
}