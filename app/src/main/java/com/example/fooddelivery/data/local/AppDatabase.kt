package com.example.fooddelivery.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.fooddelivery.data.local.dao.CartDao
import com.example.fooddelivery.data.model.CartItem

@Database(entities = [CartItem::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun cartDao(): CartDao
}
