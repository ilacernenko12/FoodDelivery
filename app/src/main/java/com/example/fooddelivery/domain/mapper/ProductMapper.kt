package com.example.fooddelivery.domain.mapper

import com.example.fooddelivery.data.model.ProductResponse
import com.example.fooddelivery.domain.mapper.base.Mapper
import com.example.fooddelivery.domain.model.Product
import javax.inject.Inject

class ProductMapper @Inject constructor() : Mapper<ProductResponse, Product>() {
    override fun map(from: ProductResponse) = from.run {
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