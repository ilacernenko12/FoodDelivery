package com.example.fooddelivery.presentation.adapter.cart

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.fooddelivery.databinding.CartItemBinding
import com.example.fooddelivery.domain.model.CartItemDomain
import com.example.fooddelivery.domain.model.Product

class CartViewHolder(private val binding: CartItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(cartItemDomain: CartItemDomain, onCountChanged: (CartItemDomain, Int) -> Unit) {
        binding.vBtnCartCountButton.onCountChanged = { newCount ->
            onCountChanged.invoke(cartItemDomain, newCount)
        }

        binding.vTvCartCoast.text = cartItemDomain.count.toString() + " Br"
        binding.vTvCartProductName.text = cartItemDomain.productName

        Glide.with(itemView)
            .load(cartItemDomain.photoUrl)
            .into(binding.vTvCartProductPhoto)
    }
}