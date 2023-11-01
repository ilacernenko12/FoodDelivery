package com.example.fooddelivery.presentation.cart

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fooddelivery.domain.model.CartItemDomain
import com.example.fooddelivery.domain.model.Product
import com.example.fooddelivery.domain.usecase.ManageCartUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor(
    private val manageCartUseCase: ManageCartUseCase
) : ViewModel() {

    val products: Flow<List<CartItemDomain>> = flow {
        val data = manageCartUseCase.getGoodsOnCart().toList()
        emit(data)
    }.flowOn(Dispatchers.IO)

    fun onCountChanged(cartItemDomain: CartItemDomain, count: Int) {
        println("HUIHUHIUHIUHIHUIHUIHUIHU")
    }
}