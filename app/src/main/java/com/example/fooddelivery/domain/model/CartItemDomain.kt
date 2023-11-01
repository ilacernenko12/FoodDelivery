package com.example.fooddelivery.domain.model

data class CartItemDomain(
    val id: Int,
    val productName: String,
    val photoUrl: String,
    val count: Int,
    val totalCost: Double
)