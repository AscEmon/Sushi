package com.example.sushi.features.product_detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.sushi.model.Product
import com.example.sushi.ui.common.BaseScreen

@Composable
fun ProductDetailScreen(product: Product?, navController: NavController) {

    BaseScreen(
        title = "Product Details", navController = navController, content = {
            Column(

                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {

                AsyncImage(
                    model = product?.imageUrl,
                    contentDescription = product?.name,
                    modifier =Modifier.fillMaxWidth().height(400.dp))
                Spacer(Modifier.padding(top = 20.dp))
                Text(text = "${product?.name}")
                Spacer(Modifier.padding(vertical = 8.dp))
                Text(text = "${product?.price}")

            }
        }

    )

}
