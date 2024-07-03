package com.baltsarak.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.baltsarak.presentation.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationBarView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.bottomNavigation.setOnItemSelectedListener(onItemSelectedListener)

        goToFirstFragment()
        setNavigationBarColor(R.color.black)
    }

    private fun setNavigationBarColor(colorResId: Int) {
        val color = ContextCompat.getColor(this, colorResId)
        window.navigationBarColor = color
    }

    private fun goToPlaceholderFragment(string: String) {
        val placeholderFragment = PlaceholderFragment.newInstance(string)
        supportFragmentManager
            .beginTransaction()
            .addToBackStack(null)
            .replace(R.id.main_screen_fragment_container, placeholderFragment)
            .commit()
    }

    private fun goToFirstFragment() {
        supportFragmentManager
            .beginTransaction()
            .addToBackStack(null)
            .replace(R.id.main_screen_fragment_container, FirstFragment())
            .commit()
    }

    private val onItemSelectedListener = NavigationBarView.OnItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_air_tickets -> {
                goToFirstFragment()
                true
            }

            R.id.navigation_hotels -> {
                goToPlaceholderFragment(getString(R.string.hotels))
                true
            }

            R.id.navigation_in_short -> {
                goToPlaceholderFragment(getString(R.string.in_short))
                true
            }

            R.id.navigation_subscriptions -> {
                goToPlaceholderFragment(getString(R.string.subscriptions))
                true
            }

            R.id.navigation_profile -> {
                goToPlaceholderFragment(getString(R.string.profile))
                true
            }

            else -> false
        }
    }
}