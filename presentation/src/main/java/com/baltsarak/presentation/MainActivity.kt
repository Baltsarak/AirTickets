package com.baltsarak.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.baltsarak.presentation.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel = (application as ProvideViewModel).viewModel()
//        viewModel.allTicketsLiveData.observe(this) {}
//        viewModel.musicOffersLiveData.observe(this) {}
//        viewModel.ticketsOffersLiveData.observe(this) {}
        viewModel.load()

        val bottomNavigation: BottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomNavigation.setOnItemSelectedListener(onItemSelectedListener)
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