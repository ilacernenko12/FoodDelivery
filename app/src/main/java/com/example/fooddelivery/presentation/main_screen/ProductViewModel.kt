package com.example.fooddelivery.presentation.main_screen

import androidx.lifecycle.ViewModel
import com.example.fooddelivery.data.model.ProductResponse
import com.example.fooddelivery.data.repository.ProductRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(private val productRepositoryImpl: ProductRepositoryImpl) : ViewModel() {
    val products: Flow<List<ProductResponse>> = flow {
        val data = productRepositoryImpl.getProducts()
        emit(data)
    }.flowOn(Dispatchers.IO)
}
