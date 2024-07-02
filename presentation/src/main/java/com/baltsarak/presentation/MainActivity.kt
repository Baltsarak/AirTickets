package com.baltsarak.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.baltsarak.presentation.databinding.ActivityMainBinding
import com.baltsarak.presentation.di.ViewModelFactory
import com.google.android.material.navigation.NavigationBarView
import dagger.android.AndroidInjection
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.bottomNavigation.setOnItemSelectedListener(onItemSelectedListener)

        supportFragmentManager
            .beginTransaction()
            .addToBackStack(null)
            .replace(R.id.main_screen_fragment_container, FirstFragment())
            .commit()

//        viewModel.allTicketsLiveData.observe(this) {}
//        viewModel.musicOffersLiveData.observe(this) {}
//        viewModel.ticketsOffersLiveData.observe(this) {}
        viewModel.load()
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