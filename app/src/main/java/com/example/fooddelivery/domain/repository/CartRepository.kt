package com.example.fooddelivery.domain.repository

import com.example.fooddelivery.domain.model.CartItemDomain
import com.example.fooddelivery.domain.model.Product

interface CartRepository {
    suspend fun addToCart(product: Product, count: Int)
    suspend fun removeFromCart(product: Product)

    suspend fun getGoodsOnCart(): List<CartItemDomain>
}