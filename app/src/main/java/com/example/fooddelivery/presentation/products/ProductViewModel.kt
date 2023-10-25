package com.example.fooddelivery.presentation.products

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.fooddelivery.domain.model.Product
import com.example.fooddelivery.domain.usecase.GetAllProductsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(private val getAllProductsUseCase: GetAllProductsUseCase) :
    ViewModel() {
    val products: Flow<List<Product>> = flow {
        val data = getAllProductsUseCase.execute().toList()
        emit(data)
    }.flowOn(Dispatchers.IO)

    fun onCountChanged(count: Int) {
        Log.d("DEBUGSOSI: ",count.toString())
    }
}
