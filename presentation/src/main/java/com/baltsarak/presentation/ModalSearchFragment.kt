package com.baltsarak.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import com.baltsarak.presentation.databinding.FragmentModalSearchBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class ModalSearchFragment : BottomSheetDialogFragment() {

    private var _binding: FragmentModalSearchBinding? = null
    private val binding: FragmentModalSearchBinding
        get() = _binding ?: throw RuntimeException("FragmentModalSearchBinding is null")

    private lateinit var city: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            city = it.getString(ARG_CITY) ?: ""
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentModalSearchBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        settingBottomSheetHeight(view)

        binding.etFrom.filters = arrayOf(CyrillicInputFilter())
        binding.etTo.filters = arrayOf(CyrillicInputFilter())

        binding.etFrom.setText(city)

        setClickListeners()
    }

    private fun setClickListeners() {
        binding.clear.setOnClickListener { binding.etTo.text.clear() }
        binding.ivDifficultRoute.setOnClickListener {
            goToPlaceholder(getString(R.string.difficult_route))
            dismiss()
        }
        binding.ivAnywhere.setOnClickListener {
            binding.etTo.setText(getString(R.string.anywhere))
            goToTickets()
        }
        binding.ivWeekend.setOnClickListener {
            goToPlaceholder(getString(R.string.weekend))
            dismiss()
        }
        binding.ivHotTickets.setOnClickListener {
            goToPlaceholder(getString(R.string.hot_tickets))
            dismiss()
        }
        binding.istanbul.setOnClickListener {
            binding.etTo.setText(getString(R.string.istanbul))
            goToTickets()
        }
        binding.sochi.setOnClickListener {
            binding.etTo.setText(getString(R.string.sochi))
            goToTickets()
        }
        binding.phuket.setOnClickListener {
            binding.etTo.setText(getString(R.string.phuket))
            goToTickets()
        }
        binding.etTo.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                goToTickets()
                true
            } else {
                false
            }
        }
    }

    private fun goToPlaceholder(string: String) {
        val placeholderFragment = PlaceholderFragmentWithBackButton.newInstance(string)
        requireActivity().supportFragmentManager
            .beginTransaction()
            .replace(R.id.main_screen_fragment_container, placeholderFragment)
            .addToBackStack(null)
            .commit()
    }

    private fun goToTickets() {
        val fromCity = binding.etFrom.text.toString()
        val toCity = binding.etTo.text.toString()
        val flightSelectionFragment = FlightSelectionFragment.newInstance(fromCity, toCity)

        requireActivity().supportFragmentManager
            .beginTransaction()
            .addToBackStack(null)
            .replace(R.id.main_screen_fragment_container, flightSelectionFragment)
            .commit()
        dismiss()
    }

    private fun settingBottomSheetHeight(view: View) {
        view.viewTreeObserver.addOnGlobalLayoutListener {
            val bottomSheet = dialog?.findViewById<View>(
                com.google.android.material.R.id.design_bottom_sheet
            )
            val bottomSheetHeight = requireContext()
                .resources
                .getDimensionPixelSize(R.dimen.bottom_sheet_height)
            bottomSheet?.layoutParams?.height = bottomSheetHeight
            val behavior = BottomSheetBehavior.from(bottomSheet!!)
            behavior.state = BottomSheetBehavior.STATE_EXPANDED
        }
    }

    companion object {
        private const val ARG_CITY = "city"

        fun newInstance(city: String): ModalSearchFragment {
            val fragment = ModalSearchFragment()
            val args = Bundle()
            args.putString(ARG_CITY, city)
            fragment.arguments = args
            return fragment
        }
    }
}