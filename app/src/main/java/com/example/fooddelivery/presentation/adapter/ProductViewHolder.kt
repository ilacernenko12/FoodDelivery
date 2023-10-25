package com.example.fooddelivery.presentation.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.fooddelivery.R
import com.example.fooddelivery.domain.model.Product
import com.example.fooddelivery.presentation.utils.views.CountButton

class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val vTvCoast: TextView = itemView.findViewById(R.id.vTvCoast)
    private val vTvProductName: TextView = itemView.findViewById(R.id.vTvProductName)
    private val vTvProductPhoto: ImageView = itemView.findViewById(R.id.vTvProductPhoto)
    private val vTvWeight: TextView = itemView.findViewById(R.id.vTvWeight)
    private val vBtnCountButton = itemView.findViewById<CountButton>(R.id.vBtnCountButton)

    fun bind(product: Product, onCountChanged: (Int)->Unit) {
        vBtnCountButton.onCountChanged = { newCount->
            onCountChanged.invoke(newCount)
        }


        vTvCoast.text = product.coast.toString() + " Br"
        vTvProductName.text = product.productName
        vTvWeight.text = product.weight.toString() + " г"

        Glide.with(itemView)
            .load(product.photoUrl)
            .into(vTvProductPhoto)
    }
}