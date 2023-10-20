package com.example.fooddelivery.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.fooddelivery.R
import com.example.fooddelivery.domain.model.Product
import com.example.fooddelivery.presentation.main_screen.ButtonState

class ProductAdapter(var products: List<Product>) : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = products[position]
        holder.bind(product)
    }

    override fun getItemCount(): Int {
        return products.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val vTvCoast: TextView = itemView.findViewById(R.id.vTvCoast)
        private val vTvProductName: TextView = itemView.findViewById(R.id.vTvProductName)
        private val vTvProductPhoto: ImageView = itemView.findViewById(R.id.vTvProductPhoto)
        private val vTvWeight: TextView = itemView.findViewById(R.id.vTvWeight)
        private val vBtnAddToCard: Button = itemView.findViewById(R.id.vBtnAddToCard)
        private val vVgCollectBtn: ConstraintLayout = itemView.findViewById(R.id.vVgCollectBtn)

        fun bind(product: Product) {
            vTvCoast.text = product.coast.toString() + " Br"
            vTvProductName.text = product.productName
            vTvWeight.text = product.weight.toString() + " г"

            Glide.with(itemView)
                .load(product.photoUrl)
                .into(vTvProductPhoto)

            when(product.buttonState) {
                ButtonState.ADD_TO_CART -> {
                    vBtnAddToCard.visibility = View.VISIBLE
                    vVgCollectBtn.visibility = View.GONE
                }
                ButtonState.COLLECT -> {
                    vBtnAddToCard.visibility = View.GONE
                    vVgCollectBtn.visibility = View.VISIBLE
                }
            }
        }
    }
}
