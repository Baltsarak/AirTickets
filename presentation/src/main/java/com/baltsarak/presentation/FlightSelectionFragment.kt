package com.baltsarak.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.baltsarak.presentation.databinding.FragmentFlightSelectionBinding

class FlightSelectionFragment : Fragment() {

    private var _binding: FragmentFlightSelectionBinding? = null
    private val binding: FragmentFlightSelectionBinding
        get() = _binding ?: throw RuntimeException("FragmentFlightSelectionBinding is null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFlightSelectionBinding.inflate(inflater, container, false)
        return binding.root
    }
}