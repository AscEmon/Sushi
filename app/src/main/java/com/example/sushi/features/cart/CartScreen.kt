package com.example.sushi.features.cart

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.sushi.ui.common.BaseScreen

@SuppressLint("DefaultLocale")
@Composable
fun CartScreen(
    navController: NavController,
    cartViewModel: CartViewModel,
) {
    // collectAsState() from StateFlow -> need getValue import for 'by'
    val cartItems by cartViewModel.cartItems.collectAsState()

    BaseScreen(title = "Cart", navController = navController, showBackButton = false) { innerPadding ->
        if (cartItems.isEmpty()) {
            // simple empty state
            Text(
                text = "Your cart is empty 🛒",
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(16.dp)
            )
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 8.dp),
                contentPadding = innerPadding
            ) {
                items(cartItems) { item ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column(modifier = Modifier.weight(1f)) {
                            Text(item.product.name, style = MaterialTheme.typography.titleMedium)
                            Spacer(modifier = Modifier.height(4.dp))
                            Text("Qty: ${item.quantity}")
                            Spacer(modifier = Modifier.height(4.dp))
                            Text("Price: \$${String.format("%.2f", item.totalPrice)}")
                        }

                        Row {
                            IconButton(onClick = { cartViewModel.decreaseQuantity(item.product) }) {
                                Icon(Icons.Default.Delete, contentDescription = "Decrease")
                            }
                            IconButton(onClick = { cartViewModel.increaseQuantity(item.product) }) {
                                Icon(Icons.Default.Add, contentDescription = "Increase")
                            }
                            IconButton(onClick = { cartViewModel.removeFromCart(item.product) }) {
                                Icon(Icons.Default.Delete, contentDescription = "Remove")
                            }
                        }
                    }

                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // show total (calls calculateTotal())
            Text(
                text = "Total: ${cartViewModel.totalPrice}}",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}
