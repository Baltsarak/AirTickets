package com.baltsarak.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.baltsarak.presentation.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationBarView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.bottomNavigation.setOnItemSelectedListener(onItemSelectedListener)

        supportFragmentManager
            .beginTransaction()
            .addToBackStack(null)
            .replace(R.id.main_screen_fragment_container, FirstFragment())
            .commit()
    }

    private val onItemSelectedListener = NavigationBarView.OnItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_air_tickets -> {

                true
            }

            R.id.navigation_hotels -> {

                true
            }

            R.id.navigation_in_short -> {

                true
            }

            R.id.navigation_subscriptions -> {

                true
            }

            R.id.navigation_profile -> {

                true
            }

            else -> false
        }
    }
}