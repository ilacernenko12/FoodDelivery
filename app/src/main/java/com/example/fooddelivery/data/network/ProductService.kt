package com.example.fooddelivery.data.network

import com.example.fooddelivery.data.model.ProductResponse
import retrofit2.http.GET
import java.util.concurrent.Flow

interface ProductService {
    @GET("products")
    suspend fun getProducts(): List<ProductResponse>
}