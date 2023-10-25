package com.example.fooddelivery.presentation.utils.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.core.view.isVisible
import com.example.fooddelivery.databinding.ViewButtonCountBinding

class CountButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {
    private lateinit var binding: ViewButtonCountBinding
    private var count: Int = 0

    var onCountChanged: ((Int) -> Unit)? = null

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()

        binding = ViewButtonCountBinding.inflate(LayoutInflater.from(context), null, false)
        initListeners()
        addView(binding.root)
    }

    private fun initListeners() {
        binding.vTvProductCount.text = count.toString()

        binding.vIvPlus.setOnClickListener {
            count++;
            binding.vTvProductCount.text = count.toString()
            onCountChanged?.invoke(count)
        }
        binding.vIvMinus.setOnClickListener {
            count--
            binding.vTvProductCount.text = count.toString()
            onCountChanged?.invoke(count)

            if (count <= 0){
                binding.vBtnAddToCard.isVisible = true
                binding.vVgCollectBtn.isVisible = false
                count = 0
            }
        }

        binding.vBtnAddToCard.setOnClickListener {

            binding.vBtnAddToCard.isVisible = false
            binding.vVgCollectBtn.isVisible = true
            count = 1
            binding.vTvProductCount.text = count.toString()
            onCountChanged?.invoke(count)
        }
    }
}