package com.example.sushi.features.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.sushi.model.Product
import coil.compose.AsyncImage

@Composable
fun ProductItem(product: Product,onClick: () -> Unit, onClickProductAdd: () -> Unit) {
    Row (modifier = Modifier.fillMaxWidth().clickable { onClick() }.padding(16.dp)

    ){
        AsyncImage(
            model = product.imageUrl,
            contentDescription = product.name,
            modifier =Modifier.size(64.dp)
        )
        Spacer(Modifier.width(16.dp))
        Column{
            Text(text = product.name, style = MaterialTheme.typography.titleMedium)
            Text(text = "$${product.price}", style = MaterialTheme.typography.bodyMedium)
        }

        Button(onClick = onClickProductAdd ) {
            Text("Add to Cart")
        }
    }
}