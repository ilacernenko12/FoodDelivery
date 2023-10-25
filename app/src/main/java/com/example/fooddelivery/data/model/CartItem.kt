package com.example.fooddelivery.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cart_items")
data class CartItem(
    @PrimaryKey
    val id: Int,
    val productName: String,
    val photoUrl: String,
    val count: Int,
    val totalCost: Double
)