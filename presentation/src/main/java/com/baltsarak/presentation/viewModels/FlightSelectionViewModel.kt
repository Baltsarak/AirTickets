package com.baltsarak.presentation.viewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.baltsarak.domain.TicketRepository
import com.baltsarak.domain.entities.TicketOffer
import kotlinx.coroutines.launch
import javax.inject.Inject

class FlightSelectionViewModel @Inject constructor(
    private val repository: TicketRepository
) : ViewModel() {

    private val _ticketsOffersLiveData = MutableLiveData<List<TicketOffer>>()
    val ticketsOffersLiveData: LiveData<List<TicketOffer>> = _ticketsOffersLiveData

    init {
        viewModelScope.launch {
            val ticketOffers = repository.getTicketsOffers()
            Log.d("FlightSelectionViewModel", ticketOffers.toString())
            _ticketsOffersLiveData.value = ticketOffers
        }
    }
}