package com.baltsarak.presentation.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.baltsarak.domain.TicketRepository
import com.baltsarak.domain.entities.Ticket
import kotlinx.coroutines.launch
import javax.inject.Inject

class AllTicketsViewModel @Inject constructor(
    private val repository: TicketRepository
) : ViewModel() {
    private val _allTicketsLiveData = MutableLiveData<List<Ticket>>()
    val allTicketsLiveData: LiveData<List<Ticket>> = _allTicketsLiveData

    init {
        viewModelScope.launch {
            val tickets = repository.getAllTickets()
            _allTicketsLiveData.value = tickets
        }
    }
}