package com.example.fooddelivery.domain.mapper

import com.example.fooddelivery.data.model.CartItem
import com.example.fooddelivery.domain.model.CartItemDomain
import com.example.fooddelivery.domain.model.Product

class CartItemMapper {
    fun mapToData(product: Product, count: Int): CartItem {
        return CartItem(
            id = product.id,
            productName = product.productName,
            photoUrl = product.photoUrl,
            count = count,
            totalCost = product.coast * count
        )
    }

    fun mapToDomain(cartItem: CartItem): CartItemDomain {
        return CartItemDomain(
            id = cartItem.id,
            productName = cartItem.productName,
            photoUrl = cartItem.photoUrl,
            count = cartItem.count,
            totalCost = cartItem.totalCost
        )
    }
}
