package com.example.sushi.model

data class Product (
    val id: Int,
    val name: String,
    val price : Double = 0.0,
    val imageUrl: String = "",
)
