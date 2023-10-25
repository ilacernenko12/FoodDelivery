package com.example.fooddelivery.di

import com.example.fooddelivery.data.mapper.ProductMapper
import com.example.fooddelivery.domain.repository.ProductRepository
import com.example.fooddelivery.domain.usecase.GetAllProductsUseCase
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
        productMapper: ProductMapper
    ): GetAllProductsUseCase {
        return GetAllProductsUseCase(productRepository)
    }
}