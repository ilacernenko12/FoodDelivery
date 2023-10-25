package com.example.fooddelivery.data.local.dao

import androidx.room.*
import com.example.fooddelivery.data.model.CartItem
import kotlinx.coroutines.flow.Flow

@Dao
interface CartDao {
    @Query("SELECT * FROM cart_items")
    fun getAllCartItems(): Flow<List<CartItem>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addCartItem(cartItem: CartItem)

    @Delete
    suspend fun deleteCartItem(cartItem: CartItem)
}
