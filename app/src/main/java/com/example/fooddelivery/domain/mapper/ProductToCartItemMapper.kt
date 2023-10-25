package com.example.fooddelivery.domain.mapper

import com.example.fooddelivery.data.model.CartItem
import com.example.fooddelivery.domain.model.Product
import kotlin.math.roundToInt

class ProductToCartItemMapper {
    fun map(product: Product, count: Int): CartItem {
        return CartItem(
            id = product.id,
            productName = product.productName,
            photoUrl = product.photoUrl,
            count = count,
            totalCost = product.coast * count
        )
    }
}
