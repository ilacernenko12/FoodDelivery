package com.example.fooddelivery.presentation.adapter.cart

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fooddelivery.databinding.CartItemBinding
import com.example.fooddelivery.domain.model.CartItemDomain
import com.example.fooddelivery.domain.model.Product

class CartAdapter(
    var goodsAtCart: List<CartItemDomain>,
    private val onCountChanged: (product: CartItemDomain, newCount: Int) -> Unit
) :
    RecyclerView.Adapter<CartViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val binding = CartItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CartViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        val cartItem = goodsAtCart[position]
        holder.bind(cartItem, onCountChanged)
    }

    override fun getItemCount(): Int = goodsAtCart.size
}