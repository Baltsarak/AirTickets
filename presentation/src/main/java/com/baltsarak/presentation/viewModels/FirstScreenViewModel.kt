package com.baltsarak.presentation.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.baltsarak.domain.TicketRepository
import com.baltsarak.domain.entities.MusicOffer
import kotlinx.coroutines.launch
import javax.inject.Inject

class FirstScreenViewModel @Inject constructor(
    private val repository: TicketRepository
) : ViewModel() {

    private val _musicOffersLiveData = MutableLiveData<List<MusicOffer>>()
    val musicOffersLiveData: LiveData<List<MusicOffer>> = _musicOffersLiveData

    init {
        viewModelScope.launch {
            val musicOffers = repository.getMusicOffers()
            _musicOffersLiveData.value = musicOffers
        }
    }
}