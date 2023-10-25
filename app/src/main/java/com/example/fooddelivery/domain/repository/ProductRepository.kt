package com.example.fooddelivery.domain.repository

import com.example.fooddelivery.domain.model.Product


interface ProductRepository {
    suspend fun getProducts(): List<Product>
}