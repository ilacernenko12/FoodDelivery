package com.example.fooddelivery.domain.usecase

import com.example.fooddelivery.domain.model.CartItemDomain
import com.example.fooddelivery.domain.model.Product
import com.example.fooddelivery.domain.repository.CartRepository
import javax.inject.Inject

class ManageCartUseCase @Inject constructor(
    private val cartRepository: CartRepository
) {
    suspend fun addToCart(product: Product, count: Int) {
        cartRepository.addToCart(product, count)
    }

    suspend fun removeFromCart(product: Product) {
        cartRepository.removeFromCart(product)
    }

    suspend fun getGoodsOnCart():List<CartItemDomain> =cartRepository.getGoodsOnCart()
}
