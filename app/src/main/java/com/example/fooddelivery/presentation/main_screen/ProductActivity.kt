package com.example.fooddelivery.presentation.main_screen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fooddelivery.R
import com.example.fooddelivery.presentation.adapter.ProductAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class ProductActivity : AppCompatActivity() {
    private val productViewModel: ProductViewModel by viewModels()
    private val productAdapter = ProductAdapter(emptyList())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = productAdapter

        val vTvCoast: Button = findViewById(R.id.btn)
        vTvCoast.setOnClickListener {
            productViewModel.products.onEach {
                productAdapter.products = it
                productAdapter.notifyDataSetChanged()
            }.launchIn(lifecycleScope)
        }
    }
}
