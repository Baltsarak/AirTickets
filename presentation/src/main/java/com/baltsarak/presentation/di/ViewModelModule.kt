package com.baltsarak.presentation.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.baltsarak.presentation.viewModels.AllTicketsViewModel
import com.baltsarak.presentation.viewModels.FirstScreenViewModel
import com.baltsarak.presentation.viewModels.FlightSelectionViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(FirstScreenViewModel::class)
    abstract fun bindFirstScreenViewModel(viewModel: FirstScreenViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(FlightSelectionViewModel::class)
    abstract fun bindFlightSelectionViewModel(viewModel: FlightSelectionViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(AllTicketsViewModel::class)
    abstract fun bindAllTicketsViewModel(viewModel: AllTicketsViewModel): ViewModel
}