package com.example.fooddelivery.data.repository

import com.example.fooddelivery.data.local.dao.CartDao
import com.example.fooddelivery.domain.mapper.ProductToCartItemMapper
import com.example.fooddelivery.domain.model.Product
import com.example.fooddelivery.domain.repository.CartRepository
import javax.inject.Inject

class CartRepositoryImpl @Inject constructor(
    private val cartDao: CartDao,
    private val mapper: ProductToCartItemMapper
) : CartRepository {
    override suspend fun addToCart(product: Product, count: Int) {
        val cartItem = mapper.map(product = product, count = count)
        cartDao.addCartItem(cartItem)
    }

    override suspend fun removeFromCart(product: Product) {

    }
}