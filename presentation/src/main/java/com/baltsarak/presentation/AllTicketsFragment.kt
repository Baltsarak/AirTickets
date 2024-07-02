package com.baltsarak.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.baltsarak.presentation.adapter.TicketAdapter
import com.baltsarak.presentation.databinding.FragmentAllTicketsBinding
import com.baltsarak.presentation.di.ViewModelFactory
import com.baltsarak.presentation.viewModels.AllTicketsViewModel
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class AllTicketsFragment : Fragment() {

    private lateinit var adapter: TicketAdapter

    private var _binding: FragmentAllTicketsBinding? = null
    private val binding: FragmentAllTicketsBinding
        get() = _binding ?: throw RuntimeException("FragmentAllTicketsBinding is null")

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var viewModel: AllTicketsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)
        viewModel = viewModelFactory.create(AllTicketsViewModel::class.java)
    }

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
        binding.rvAllTicketsList.adapter = adapter

        val spacingInPixels = resources.getDimensionPixelSize(R.dimen.ticket_item_spacing)
        binding.rvAllTicketsList.addItemDecoration(TicketItemDecoration(spacingInPixels))

        viewModel.allTicketsLiveData.observe(viewLifecycleOwner, Observer { items ->
            adapter.submitList(items)
        })
    }
}