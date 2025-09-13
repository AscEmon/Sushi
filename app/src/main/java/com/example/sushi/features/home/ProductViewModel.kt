package com.example.sushi.features.home


import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.sushi.data.MockProductRepository
import com.example.sushi.model.Product


class ProductViewModel : ViewModel() {
    var products = mutableStateOf<List<Product>>(emptyList())
        private set

    init {
        loadProduct()
    }
    private fun loadProduct(){
        products.value = MockProductRepository.products
    }

}
