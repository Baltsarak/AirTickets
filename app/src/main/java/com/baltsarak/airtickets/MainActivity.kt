package com.baltsarak.airtickets

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


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