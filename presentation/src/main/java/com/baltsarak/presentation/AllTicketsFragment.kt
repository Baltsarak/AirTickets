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

        arguments?.let {
            binding.tvFrom.text = it.getString(ARG_FROM_CITY)
            binding.tvTo.text = it.getString(ARG_TO_CITY)
            binding.tvSearchData.text = it.getString(ARG_DATE)
            binding.tvNumberOfPassengers.text = it.getString(ARG_PASSENGERS)
        }

        adapter = TicketAdapter()
        binding.rvAllTicketsList.adapter = adapter

        val spacingInPixels = resources.getDimensionPixelSize(R.dimen.ticket_item_spacing)
        binding.rvAllTicketsList.addItemDecoration(TicketItemDecoration(spacingInPixels))

        viewModel.allTicketsLiveData.observe(viewLifecycleOwner, Observer { items ->
            adapter.submitList(items)
        })

        binding.bottomBack.setOnClickListener {
            requireActivity().supportFragmentManager.popBackStack()
        }
    }

    companion object {
        private const val ARG_FROM_CITY = "from_city"
        private const val ARG_TO_CITY = "to_city"
        private const val ARG_DATE = "date"
        private const val ARG_PASSENGERS = "passengers"

        fun newInstance(fromCity: String, toCity: String, date: String, passengers: String): AllTicketsFragment {
            val fragment = AllTicketsFragment()
            val args = Bundle().apply {
                putString(ARG_FROM_CITY, fromCity)
                putString(ARG_TO_CITY, toCity)
                putString(ARG_DATE, date)
                putString(ARG_PASSENGERS, passengers)
            }
            fragment.arguments = args
            return fragment
        }
    }
}