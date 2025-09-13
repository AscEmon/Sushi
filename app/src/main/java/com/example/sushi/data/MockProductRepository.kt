package com.example.sushi.data

import com.example.sushi.model.Product

object MockProductRepository {
    val products = listOf(
        Product(id= 1, price =  59.99,  name= "Sneakers", imageUrl = "https://picsum.photos/200/200?random=1"),
        Product(2, "Backpack", 39.99, "https://picsum.photos/200/200?random=2"),
        Product(3, "Smartwatch", 99.99, "https://picsum.photos/200/200?random=3"),
        Product(4, "Headphones", 29.99, "https://picsum.photos/200/200?random=4")
    )
}
