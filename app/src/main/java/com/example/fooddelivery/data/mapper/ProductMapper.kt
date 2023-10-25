package com.example.fooddelivery.data.mapper

import com.example.fooddelivery.data.model.ProductResponse
import com.example.fooddelivery.domain.model.Product
import javax.inject.Inject

class ProductMapper @Inject constructor()  {
    fun mapResponseToDomain(from: ProductResponse) = from.run {
        Product(
            coast = coast,
            description = description,
            id = id,
            photoUrl = photoUrl,
            productName = productName,
            weight = weight
        )
    }
}