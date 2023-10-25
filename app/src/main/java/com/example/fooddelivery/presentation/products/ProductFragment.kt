package com.example.fooddelivery.presentation.products

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.example.fooddelivery.databinding.FragmentProductBinding
import com.example.fooddelivery.presentation.adapter.ProductAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class ProductFragment : Fragment() {

    private lateinit var binding: FragmentProductBinding
    private val productViewModel: ProductViewModel by viewModels()
    private val productAdapter = ProductAdapter(emptyList()) { newCount ->
        productViewModel.onCountChanged(newCount)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProductBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.recyclerView.adapter = productAdapter

        productViewModel.products.onEach {
            productAdapter.products = it
            productAdapter.notifyDataSetChanged()
        }.launchIn(lifecycleScope)
    }
}