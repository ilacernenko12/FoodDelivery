package com.example.fooddelivery.presentation.main_screen

import androidx.lifecycle.ViewModel
import com.example.fooddelivery.data.model.ProductResponse
import com.example.fooddelivery.data.repository.ProductRepositoryImpl
import com.example.fooddelivery.domain.model.Product
import com.example.fooddelivery.domain.usecase.GetAllProductsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(private val getAllProductsUseCase: GetAllProductsUseCase) : ViewModel() {
    val products: Flow<List<Product>> = flow {
        val data = getAllProductsUseCase.execute().toList()
        emit(data)
    }.flowOn(Dispatchers.IO)
}
