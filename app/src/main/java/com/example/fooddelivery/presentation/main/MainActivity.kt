package com.example.fooddelivery.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.fooddelivery.R
import com.example.fooddelivery.presentation.cart.CartFragment
import com.example.fooddelivery.presentation.contact.ContactFragment
import com.example.fooddelivery.presentation.products.ProductFragment
import com.example.fooddelivery.presentation.profile.ProfileFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var bottomNavigationMenu: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadFragment(ProductFragment())

        bottomNavigationMenu = findViewById(R.id.bottomNavigationMenu)

        bottomNavigationMenu.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.product_navigation -> {
                    loadFragment(ProductFragment())
                    true
                }
                R.id.profile_navigation -> {
                    loadFragment(ProfileFragment())
                    true
                }
                R.id.contact_navigation -> {
                    loadFragment(ContactFragment())
                    true
                }
                else -> {
                    loadFragment(CartFragment())
                    true
                }
            }
        }
    }

    private fun loadFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.apply {
            replace(R.id.fragmentContainer, fragment)
            addToBackStack(null)
            commit()
        }
    }
}