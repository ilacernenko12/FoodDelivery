package com.example.fooddelivery.domain.usecase

import com.example.fooddelivery.domain.mapper.ProductMapper
import com.example.fooddelivery.domain.model.Product
import com.example.fooddelivery.domain.repository.ProductRepository
import javax.inject.Inject

class GetAllProductsUseCase @Inject constructor(
    private val productRepository: ProductRepository,
    private val productMapper: ProductMapper
) {
    suspend fun execute(): List<Product> {
        val productResponses = productRepository.getProducts()
        return productResponses.map { productMapper.mapResponseToDomain(it) }
    }
}