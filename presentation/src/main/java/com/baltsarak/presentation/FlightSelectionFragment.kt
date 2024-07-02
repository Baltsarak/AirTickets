package com.baltsarak.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.baltsarak.presentation.databinding.FragmentFlightSelectionBinding
import com.baltsarak.presentation.di.ViewModelFactory
import com.baltsarak.presentation.viewModels.FlightSelectionViewModel
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class FlightSelectionFragment : Fragment() {

    private var _binding: FragmentFlightSelectionBinding? = null
    private val binding: FragmentFlightSelectionBinding
        get() = _binding ?: throw RuntimeException("FragmentFlightSelectionBinding is null")

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var viewModel: FlightSelectionViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)
        viewModel = viewModelFactory.create(FlightSelectionViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFlightSelectionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val items = viewModel.ticketsOffersLiveData.value
        binding.buttonViewAllTickets.setOnClickListener {
            requireActivity().supportFragmentManager
                .beginTransaction()
                .addToBackStack(null)
                .replace(R.id.main_screen_fragment_container, AllTicketsFragment())
                .commit()
        }
    }
}