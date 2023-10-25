package com.example.fooddelivery.data.repository

import com.example.fooddelivery.data.model.ProductResponse
import com.example.fooddelivery.data.network.ProductService
import com.example.fooddelivery.data.mapper.ProductMapper
import com.example.fooddelivery.domain.model.Product
import com.example.fooddelivery.domain.repository.ProductRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(private val productService: ProductService, private val mapper: ProductMapper) :
    ProductRepository {
    override suspend fun getProducts(): List<Product> {
        return productService.getProducts().map { mapper.mapResponseToDomain(it) }
    }
}
