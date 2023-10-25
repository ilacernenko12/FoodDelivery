package com.example.fooddelivery.di

import com.example.fooddelivery.data.mapper.ProductMapper
import com.example.fooddelivery.domain.repository.ProductRepository
import com.example.fooddelivery.data.repository.ProductRepositoryImpl
import com.example.fooddelivery.data.network.ProductService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://192.168.0.104:8080/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideProductService(retrofit: Retrofit): ProductService {
        return retrofit.create(ProductService::class.java)
    }

    @Provides
    fun provideProductRepository(): ProductRepository {
        return ProductRepositoryImpl(provideProductService(provideRetrofit()), ProductMapper())
    }
}