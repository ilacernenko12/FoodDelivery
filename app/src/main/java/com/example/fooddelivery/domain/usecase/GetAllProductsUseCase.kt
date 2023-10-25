package com.example.fooddelivery.domain.usecase

import com.example.fooddelivery.domain.model.Product
import com.example.fooddelivery.domain.repository.ProductRepository
import javax.inject.Inject

class GetAllProductsUseCase @Inject constructor(
    private val productRepository: ProductRepository
) {
    suspend fun execute(): List<Product> =productRepository.getProducts()
}