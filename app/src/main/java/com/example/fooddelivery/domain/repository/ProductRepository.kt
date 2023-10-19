package com.example.fooddelivery.domain.repository

import com.example.fooddelivery.data.model.ProductResponse
import com.example.fooddelivery.domain.model.Product
import java.util.concurrent.Flow


interface ProductRepository {
    suspend fun getProducts(): List<ProductResponse>
}