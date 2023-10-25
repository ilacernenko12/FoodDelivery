package com.example.fooddelivery.di

import com.example.fooddelivery.data.mapper.ProductResponseMapper
import com.example.fooddelivery.domain.repository.CartRepository
import com.example.fooddelivery.domain.repository.ProductRepository
import com.example.fooddelivery.domain.usecase.GetAllProductsUseCase
import com.example.fooddelivery.domain.usecase.ManageCartUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    @Singleton
    fun provideGetProductsUseCase(
        productRepository: ProductRepository,
        productMapper: ProductResponseMapper
    ): GetAllProductsUseCase {
        return GetAllProductsUseCase(productRepository)
    }

    @Provides
    @Singleton
    fun provideManageCartUseCase(cartRepository: CartRepository): ManageCartUseCase {
        return ManageCartUseCase(cartRepository)
    }
}