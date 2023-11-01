package com.example.fooddelivery.di

import com.example.fooddelivery.data.mapper.ProductResponseMapper
import com.example.fooddelivery.domain.mapper.CartItemMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MapperModule {
    @Provides
    @Singleton
    fun provideProductMapper(): ProductResponseMapper {
        return ProductResponseMapper()
    }

    @Provides
    @Singleton
    fun provideProductToCartItemMapper(): CartItemMapper {
        return CartItemMapper()
    }
}