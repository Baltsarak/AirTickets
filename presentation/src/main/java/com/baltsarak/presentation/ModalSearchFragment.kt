package com.baltsarak.presentation

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

        binding.etTo.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if (!s.isNullOrEmpty()) {
                    requireActivity().supportFragmentManager
                        .beginTransaction()
                        .addToBackStack(null)
                        .replace(R.id.main_screen_fragment_container, FlightSelectionFragment())
                        .commit()

                    dismiss()
                }
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })
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