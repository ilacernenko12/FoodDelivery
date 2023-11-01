package com.example.fooddelivery.data.repository

import com.example.fooddelivery.data.local.dao.CartDao
import com.example.fooddelivery.domain.mapper.CartItemMapper
import com.example.fooddelivery.domain.model.CartItemDomain
import com.example.fooddelivery.domain.model.Product
import com.example.fooddelivery.domain.repository.CartRepository
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class CartRepositoryImpl @Inject constructor(
    private val cartDao: CartDao,
    private val mapper: CartItemMapper
) : CartRepository {
    override suspend fun addToCart(product: Product, count: Int) {
        val cartItem = mapper.mapToData(product = product, count = count)
        cartDao.addCartItem(cartItem)
    }

    override suspend fun removeFromCart(product: Product) {

    }

    override suspend fun getGoodsOnCart(): List<CartItemDomain> {
        return cartDao.getAllCartItems().map { mapper.mapToDomain(it) }
    }
}