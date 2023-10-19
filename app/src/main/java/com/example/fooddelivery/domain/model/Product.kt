package com.example.fooddelivery.domain.model

data class Product(
    val coast: Double,
    val description: String,
    val id: Int,
    val photoUrl: String,
    val productName: String,
    val weight: Int
)