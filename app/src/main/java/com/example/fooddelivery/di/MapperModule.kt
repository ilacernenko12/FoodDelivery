package com.example.fooddelivery.di

import com.example.fooddelivery.domain.mapper.ProductMapper
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
    fun provideProductMapper(): ProductMapper {
        return ProductMapper()
    }

}