package com.baltsarak.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.baltsarak.domain.TicketRepository
import com.baltsarak.domain.entities.MusicOffer
import com.baltsarak.domain.entities.Ticket
import com.baltsarak.domain.entities.TicketOffer
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val repository : TicketRepository
) : ViewModel() {

    private val _musicOffersLiveData = MutableLiveData<List<MusicOffer>>()
    val musicOffersLiveData: LiveData<List<MusicOffer>> = _musicOffersLiveData

    private val _ticketsOffersLiveData = MutableLiveData<List<TicketOffer>>()
    val ticketsOffersLiveData: LiveData<List<TicketOffer>> = _ticketsOffersLiveData

    private val _allTicketsLiveData = MutableLiveData<List<Ticket>>()
    val allTicketsLiveData: LiveData<List<Ticket>> = _allTicketsLiveData

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