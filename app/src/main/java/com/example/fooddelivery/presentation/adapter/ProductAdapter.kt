package com.example.fooddelivery.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.fooddelivery.data.model.ProductResponse
import com.example.fooddelivery.R

class ProductAdapter(var products: List<ProductResponse>) : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {
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
        private val vTvDescription: TextView = itemView.findViewById(R.id.vTvDescription)
        private val vTvWeight: TextView = itemView.findViewById(R.id.vTvWeight)

        fun bind(product: ProductResponse) {
            vTvCoast.text = product.coast.toString()
            vTvProductName.text = product.productName
            vTvDescription.text = product.description
            vTvWeight.text = product.weight.toString()

            Glide.with(itemView)
                .load(product.photoUrl)
                .into(vTvProductPhoto)
        }
    }
}
