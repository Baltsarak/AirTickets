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

        binding.etTo.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                requireActivity().supportFragmentManager
                    .beginTransaction()
                    .addToBackStack(null)
                    .replace(R.id.main_screen_fragment_container, FlightSelectionFragment())
                    .commit()
                dismiss()
                true
            } else {
                false
            }
        }
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
}