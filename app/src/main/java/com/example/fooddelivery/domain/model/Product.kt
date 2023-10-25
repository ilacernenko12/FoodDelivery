package com.example.fooddelivery.domain.model

data class Product(
    val id: Int,
    val coast: Double,
    val description: String,
    val photoUrl: String,
    val productName: String,
    val weight: Int
)