package com.baltsarak.presentation.di

import com.baltsarak.presentation.AllTicketsFragment
import com.baltsarak.presentation.FirstFragment
import com.baltsarak.presentation.FlightSelectionFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract fun contributeFirstFragment(): FirstFragment

    @ContributesAndroidInjector
    abstract fun contributeFlightSelectionFragment(): FlightSelectionFragment

    @ContributesAndroidInjector
    abstract fun contributeAllTicketsFragment(): AllTicketsFragment
}