package com.baltsarak.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.baltsarak.domain.entities.Ticket
import com.baltsarak.presentation.adapter.TicketAdapter
import com.baltsarak.presentation.databinding.FragmentAllTicketsBinding

class AllTicketsFragment : Fragment() {

    private lateinit var adapter: TicketAdapter

    private var _binding: FragmentAllTicketsBinding? = null
    private val binding: FragmentAllTicketsBinding
        get() = _binding ?: throw RuntimeException("FragmentAllTicketsBinding is null")

    private val items = listOf(
        Ticket(1, "Прилет вечером", 6460, 70000909, 70002009, "DME", "AER", false),
        Ticket(2, null, 6733, 70000909, 70002009, "DME", "AER", true),
        Ticket(3, null, 8540, 70000909, 70002009, "DME", "AER", false)
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAllTicketsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = TicketAdapter()
        adapter.submitList(items)
        binding.rvAllTicketsList.adapter = adapter
    }
}