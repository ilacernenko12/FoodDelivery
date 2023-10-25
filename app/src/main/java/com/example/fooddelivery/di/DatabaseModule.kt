package com.example.fooddelivery.di

import android.content.Context
import androidx.room.Room
import com.example.fooddelivery.data.local.AppDatabase
import com.example.fooddelivery.data.local.dao.CartDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "app_database")
            .build()
    }

    @Provides
    fun provideCartDao(database: AppDatabase): CartDao {
        return database.cartDao()
    }
}