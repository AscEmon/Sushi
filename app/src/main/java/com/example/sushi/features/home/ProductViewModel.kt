package com.example.sushi.features.home


import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.sushi.data.MockProductRepository


class ProductViewModel : ViewModel() {
    var products = mutableStateOf(MockProductRepository.products)
        private set
}
