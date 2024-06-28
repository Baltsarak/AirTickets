package com.baltsarak.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.baltsarak.domain.TicketRepository
import kotlinx.coroutines.launch

class MainViewModel(
    private val repository : TicketRepository
) : ViewModel() {

    private val _musicOffersLiveData = MutableLiveData<Unit>()
    val musicOffersLiveData: LiveData<Unit> = _musicOffersLiveData

    private val _ticketsOffersLiveData = MutableLiveData<Unit>()
    val ticketsOffersLiveData: LiveData<Unit> = _ticketsOffersLiveData

    private val _allTicketsLiveData = MutableLiveData<Unit>()
    val allTicketsLiveData: LiveData<Unit> = _allTicketsLiveData

    fun load() {
        viewModelScope.launch {
//            val allTickets = repository.getAllTickets()
//            _allTicketsLiveData.value = allTickets
//            val musicOffers = repository.getMusicOffers()
//            _musicOffersLiveData.value = musicOffers
//            val ticketOffers = repository.getTicketsOffers()
//            _ticketsOffersLiveData.value = ticketOffers
        }
    }
}