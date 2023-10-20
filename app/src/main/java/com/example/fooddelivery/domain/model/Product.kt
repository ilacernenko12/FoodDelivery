package com.example.fooddelivery.domain.model

import com.example.fooddelivery.presentation.main_screen.ButtonState

data class Product(
    val coast: Double,
    val description: String,
    val id: Int,
    val photoUrl: String,
    val productName: String,
    val weight: Int,
    var buttonState: ButtonState = ButtonState.ADD_TO_CART
)