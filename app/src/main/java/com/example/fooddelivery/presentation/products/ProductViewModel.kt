package com.example.fooddelivery.presentation.products

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fooddelivery.domain.model.Product
import com.example.fooddelivery.domain.usecase.GetAllProductsUseCase
import com.example.fooddelivery.domain.usecase.ManageCartUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(
    private val getAllProductsUseCase: GetAllProductsUseCase,
    private val manageCartUseCase: ManageCartUseCase
) :
    ViewModel() {
    val products: Flow<List<Product>> = flow {
        val data = getAllProductsUseCase.execute().toList()
        emit(data)
    }.flowOn(Dispatchers.IO)

    fun onCountChanged(product: Product, count: Int) {
        viewModelScope.launch {
            manageCartUseCase.addToCart(product = product, count = count)
        }
    }
}
