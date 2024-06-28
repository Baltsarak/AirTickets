package com.baltsarak.airtickets

import android.app.Application
import com.baltsarak.data.TicketRepositoryImpl
import com.baltsarak.domain.TicketRepository
import com.baltsarak.presentation.MainViewModel
import com.baltsarak.presentation.ProvideViewModel

class AirTicketsApp : Application(), ProvideViewModel {

    private lateinit var viewModel: MainViewModel

    override fun onCreate() {
        super.onCreate()
        val repository: TicketRepository = TicketRepositoryImpl()
        viewModel = MainViewModel(repository = repository)
    }

    override fun viewModel(): MainViewModel {
        return viewModel
    }
}