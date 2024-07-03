package com.baltsarak.presentation

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.baltsarak.domain.entities.TicketOffer
import com.baltsarak.presentation.databinding.FragmentFlightSelectionBinding
import com.baltsarak.presentation.di.ViewModelFactory
import com.baltsarak.presentation.viewModels.FlightSelectionViewModel
import dagger.android.support.AndroidSupportInjection
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale
import javax.inject.Inject

class FlightSelectionFragment : Fragment() {

    private var _binding: FragmentFlightSelectionBinding? = null
    private val binding: FragmentFlightSelectionBinding
        get() = _binding ?: throw RuntimeException("FragmentFlightSelectionBinding is null")

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private lateinit var viewModel: FlightSelectionViewModel

    private var fromCity: String? = null
    private var toCity: String? = null

    private var departureDate: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)
        viewModel = viewModelFactory.create(FlightSelectionViewModel::class.java)
        arguments?.let {
            fromCity = it.getString(ARG_FROM_CITY)
            toCity = it.getString(ARG_TO_CITY)
        }
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

        viewModel.ticketsOffersLiveData.observe(viewLifecycleOwner, Observer { tickets ->
            if (tickets.size >= 3) {
                updateUIWithTickets(tickets)
            }
        })

        binding.etFrom.filters = arrayOf(CyrillicInputFilter())
        binding.etTo.filters = arrayOf(CyrillicInputFilter())

        binding.etFrom.setText(fromCity)
        binding.etTo.setText(toCity)
        setCurrentDate()

        setClickListeners()
    }

    private fun updateUIWithTickets(tickets: List<TicketOffer>) {
        val ticket1 = tickets[0]
        binding.tvName.text = ticket1.title
        binding.tvFlightTimes.text = ticket1.timeRange
        binding.tvPrice.text = ticket1.price

        val ticket2 = tickets[1]
        binding.tvName2.text = ticket2.title
        binding.tvFlightTimes2.text = ticket2.timeRange
        binding.tvPrice2.text = ticket2.price

        val ticket3 = tickets[2]
        binding.tvName3.text = ticket3.title
        binding.tvFlightTimes3.text = ticket3.timeRange
        binding.tvPrice3.text = ticket3.price
    }

    private fun setClickListeners() {
        binding.changeDestinations.setOnClickListener { onChangeDestinationsClicked() }
        binding.clear.setOnClickListener { binding.etTo.text.clear() }
        binding.returnTicket.setOnClickListener { onReturnTicketClicked() }
        binding.departureDate.setOnClickListener { onDepartureDateClicked() }
        binding.previousScreen.setOnClickListener { onPreviousScreenClicked() }
        binding.buttonViewAllTickets.setOnClickListener {
            onViewAllTicketsClicked()
        }
    }

    private fun onViewAllTicketsClicked() {
        val fromCity = binding.etFrom.text.toString()
        val toCity = binding.etTo.text.toString()
        val date = departureDate ?: binding.tvDepartureDate.text.toString()
        val passengers = getString(R.string.number_of_passengers)

        val fragment = AllTicketsFragment.newInstance(fromCity, toCity, date, passengers)
        requireActivity().supportFragmentManager
            .beginTransaction()
            .replace(R.id.main_screen_fragment_container, fragment)
            .addToBackStack(null)
            .commit()
    }

    private fun onChangeDestinationsClicked() {
        val from = binding.etFrom.text.toString()
        val to = binding.etTo.text.toString()
        binding.etFrom.setText(to)
        binding.etTo.setText(from)
    }

    private fun onReturnTicketClicked() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val dateSetListener =
            DatePickerDialog.OnDateSetListener { _, selectedYear, selectedMonth, selectedDay ->
                // Обновление даты возврата
            }

        val datePickerDialog = DatePickerDialog(
            requireContext(),
            dateSetListener,
            year,
            month,
            day
        )

        datePickerDialog.show()
    }

    private fun onDepartureDateClicked() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val dateSetListener =
            DatePickerDialog.OnDateSetListener { _, selectedYear, selectedMonth, selectedDay ->
                calendar.set(selectedYear, selectedMonth, selectedDay)
                updateDateInView(calendar.time)
                val fullMonthDateFormat = SimpleDateFormat("d MMMM", Locale("ru", "RU"))
                departureDate = fullMonthDateFormat.format(calendar.time)
            }

        val datePickerDialog = DatePickerDialog(
            requireContext(),
            dateSetListener,
            year,
            month,
            day
        )

        datePickerDialog.setOnCancelListener {
            updateDateInView(calendar.time)
        }

        datePickerDialog.show()
    }

    private fun updateDateInView(date: Date) {
        val dayMonthFormat = SimpleDateFormat("d MMM", Locale("ru", "RU"))
        val dayOfWeekFormat = SimpleDateFormat("EEE", Locale("ru", "RU"))
        val formattedDate = dayMonthFormat.format(date).replace(".", "")
        val formattedDayOfWeek = dayOfWeekFormat.format(date)
        binding.departureDate.findViewById<TextView>(R.id.tv_departure_date).text = formattedDate
        binding.departureDate.findViewById<TextView>(R.id.tv_day_of_week).text =
            ", $formattedDayOfWeek"
    }

    private fun setCurrentDate() {
        val calendar = Calendar.getInstance()
        updateDateInView(calendar.time)
        val fullMonthDateFormat = SimpleDateFormat("d MMMM", Locale("ru", "RU"))
        departureDate = fullMonthDateFormat.format(calendar.time)
    }

    private fun onPreviousScreenClicked() {
        requireActivity().supportFragmentManager.popBackStack()
    }

    companion object {
        private const val ARG_FROM_CITY = "from_city"
        private const val ARG_TO_CITY = "to_city"

        fun newInstance(fromCity: String, toCity: String): FlightSelectionFragment {
            val fragment = FlightSelectionFragment()
            val args = Bundle().apply {
                putString(ARG_FROM_CITY, fromCity)
                putString(ARG_TO_CITY, toCity)
            }
            fragment.arguments = args
            return fragment
        }
    }
}