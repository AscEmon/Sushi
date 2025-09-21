package com.example.sushi.features.cart

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sushi.model.CartItem
import com.example.sushi.model.Product
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update

class  CartViewModel : ViewModel(){
    private val _cartItems = MutableStateFlow<List<CartItem>>(emptyList())
    val cartItems: StateFlow<List<CartItem>> = _cartItems
    val totalPrice: StateFlow<Double> = _cartItems
        .map { list -> list.sumOf { it.totalPrice } }
        .stateIn(viewModelScope, SharingStarted.Eagerly, 0.0)


    fun addToCart(product: Product) {
        _cartItems.update { currentItems ->
            val existing = currentItems.find { it.product.id == product.id }
            if (existing != null) {
                currentItems.map {
                    if (it.product.id == product.id) it.copy(quantity = it.quantity + 1) else it
                }
            } else {
                currentItems + CartItem(product, 1)
            }
        }

    }

    fun removeFromCart(product: Product) {
        _cartItems.update { currentItems ->
            currentItems.filterNot { it.product.id == product.id }
        }
    }


    fun increaseQuantity(product: Product) {
        _cartItems.update { currentItems ->
            currentItems.map {
                if (it.product.id == product.id) it.copy(quantity = it.quantity + 1) else it
            }
        }
    }

    fun decreaseQuantity(product: Product) {
        _cartItems.update { currentItems ->
            currentItems.mapNotNull {
                when {
                    it.product.id == product.id && it.quantity > 1 -> it.copy(quantity = it.quantity - 1)
                    it.product.id == product.id && it.quantity == 1 -> null
                    else -> it
                }
            }
        }
    }




}